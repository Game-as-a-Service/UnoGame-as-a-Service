package tw.gaas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;

import static java.util.Arrays.asList;
import static java.util.Collections.max;
import static java.util.Comparator.comparing;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

class UnoGameTest {

    private UnoGame unoGame;

    @BeforeEach
    public void init() {
        this.unoGame = new UnoGame(Deck.standard108Cards());
    }

    //當遊戲開始時，建立四位玩家
    @Test
    public void givenUnoGameCreated_whenFourPlayersJoinGame_thenGameShouldHaveFourPlayers() {
        List<Player> expectedPlayers = generatePlayers(4);
        joinGame(expectedPlayers);

        assertEquals(expectedPlayers, unoGame.getPlayers());
    }

    @Test
    public void givenUnoGameCreated_whenFivePlayersJoinGame_thenGameShouldFail() {
        List<Player> expectedPlayers = generatePlayers(5);

        assertThrows(IllegalStateException.class, () -> expectedPlayers.forEach(unoGame::join));
    }

    @Test
    public void givenThreePlayersJoinUnoGame_whenUnoGameStart_thenGameShouldFail() {
        List<Player> expectedPlayers = generatePlayers(3);
        joinGame(expectedPlayers);

        assertThrows(IllegalStateException.class, () -> unoGame.start());
    }


    @Test
    public void givenFourPlayersJoinUnoGame_whenUnoGameStart_thenGameShouldSuccess() {
        List<Player> expectedPlayers = generatePlayers(4);
        joinGame(expectedPlayers);
        //驗證 unoGame start 會有什麼狀態 ?

        unoGame.start();

        //順時鐘、
        assertNull(unoGame.getGameState().getDirection());
        assertFalse(unoGame.getGameState().isSkip());
        assertEquals(0, unoGame.getGameState().getDrawCardsAmount());
        assertNull(unoGame.getGameState().getColor());
    }


    //遊戲開始後 決定輪流順順序 抽牌 由數字最大的開始 順位為1  其餘順位

    //p1   7
    //p2   5
    //p3   3
    //p4   2
    // 比數字大小
    // 只能是數字牌 我只給他 0-9的數字牌堆抽就好了呀


    //所以甚至初始化不需要建立 deck standard108cards  等決定完誰先開始  正是開始遊戲再建立 standard108Cards
    @Test
    public void givenUnoGameStartFourPlayersDrawNumberCards0To9_whenDecideFirstPlayer_thenNumberCardsShouldBeBiggest() {
        List<Player> expectedPlayers = generatePlayers(4);
        joinGame(expectedPlayers);
        unoGame.start();
        List<TurnMove> turnMoves = unoGame.getTurnMove();
        unoGame.drawCard(1);
        for (Player player : unoGame.getPlayers()) {
            NumberCard card = (NumberCard) player.getHandCards().get(0);
            TurnMove turnMove = new TurnMove(player, card);
            turnMoves.add(turnMove);
        }

        //抽牌比大小
        Player expectedFirstPlayer = max(turnMoves, comparing(TurnMove::getNumberCard)).getPlayer();

        assertEquals(expectedFirstPlayer, unoGame.decideFirstPlayer());
    }


    // 第一張卡如果是 reverseCard 就逆時鐘開始


    private void joinGame(List<Player> expectedPlayers) {
        expectedPlayers.forEach(unoGame::join);
    }


    private List<Player> generatePlayers(int numberOfPlayers) {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player(i + "", "test" + i));
        }
        return players;
    }

}