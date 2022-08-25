package tw.gaas;

import java.util.ArrayList;
import java.util.List;

public class UnoGame {
    private final Deck deck;
    private final List<Player> players;
    private final GameState gameState;
    public static final int MAX_NUMBER_OF_PLAYERS = 4;
    private List<TurnMove> turnMove;

    public UnoGame(Deck deck) {
        this.deck = deck;
        this.players = new ArrayList<>(MAX_NUMBER_OF_PLAYERS);
        this.gameState=new GameState();
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

    public List<TurnMove> getTurnMove() {
        return turnMove;
    }


    public void drawCard(int i) {

    }

    public Player decideFirstPlayer() {
        return null;
    }
}
