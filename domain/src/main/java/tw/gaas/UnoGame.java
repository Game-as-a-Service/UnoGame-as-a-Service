package tw.gaas;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.max;
import static java.util.Comparator.comparing;
import static tw.gaas.Direction.CLOCKWISE;
import static tw.gaas.Direction.COUNTERCLOCKWISE;

public class UnoGame {
    private Deck deck;
    private final List<Player> players;
    private final GameState gameState;
    public static final int MAX_NUMBER_OF_PLAYERS = 4;
    private List<TurnMove> turnMoves;

    public UnoGame() {
        this.players = new ArrayList<>(MAX_NUMBER_OF_PLAYERS);
        this.gameState = new GameState();
    }

    public void dealFirstCard(Card card) {
        if (card instanceof ReverseCard) {
            gameState.setDirection(COUNTERCLOCKWISE);
        } else if (card instanceof NumberCard || card instanceof SkipCard ||
                card instanceof DrawTwoCard || card instanceof WildCard) {
            gameState.setDirection(CLOCKWISE);
        } else {
            throw new IllegalStateException("重新抽牌");
        }

    }

    public List<Player> getPlayers() {
        return players;
    }

    public void join(Player player) {
        if (players.size() >= MAX_NUMBER_OF_PLAYERS) {
            throw new IllegalStateException();
        }
        players.add(player);
    }

    public void start() {
        if (players.size() < MAX_NUMBER_OF_PLAYERS) {
            throw new IllegalStateException();
        }
    }

    public GameState getGameState() {
        return gameState;
    }

    public List<TurnMove> getTurnMoves() {
        return turnMoves;
    }

    public Player decideFirstPlayer() {
        deck = Deck.RedNumber0To9Cards();
        deck.shuffle();
        drawCards();
        takeTurn();
        return max(turnMoves, comparing(TurnMove::getNumberCard)).getPlayer();
    }

    private void drawCards() {
        players.forEach(p -> p.drawCard(deck.dealCard()));
    }

    private void takeTurn() {
        turnMoves = new ArrayList<>();
        //  decideFirstPlayer 的 takeTurn
        for (Player player : players) {
            NumberCard card = (NumberCard) player.getHandCards().get(0);
            turnMoves.add(new TurnMove(player, card));
        }
        // 實際遊戲takeTurn
    }
}
