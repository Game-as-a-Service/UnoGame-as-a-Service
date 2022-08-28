package tw.gaas;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.max;
import static java.util.Comparator.comparing;
import static org.junit.jupiter.api.Assertions.*;
import static tw.gaas.Direction.CLOCKWISE;
import static tw.gaas.Direction.COUNTERCLOCKWISE;

class UnoGameTest {

    private final UnoGame unoGame = new UnoGame();

    @Test
    public void givenUnoGameCreated_whenFourPlayersJoinGame_thenGameShouldHaveFourPlayers() {
        List<Player> expectedPlayers = generatePlayers(4);
        joinGame(expectedPlayers);

        assertEquals(expectedPlayers, unoGame.getPlayers());
    }

    @Test
    public void givenUnoGameCreated_whenFivePlayersJoinGame_thenGameShouldFail() {
        List<Player> expectedPlayers = generatePlayers(5);

        assertThrows(IllegalStateException.class, () -> joinGame(expectedPlayers));
    }

    @Test
    public void givenThreePlayersJoinUnoGame_whenUnoGameStart_thenGameShouldFail() {
        givenFourPlayersJoinUnoGame(3);

        assertThrows(IllegalStateException.class, unoGame::start);
    }

    @Test
    public void givenFourPlayersJoinUnoGame_whenUnoGameStart_thenGameShouldSuccess() {
        givenFourPlayersJoinUnoGame(4);

        unoGame.start();

        assertNull(unoGame.getGameState().getDirection());
        assertFalse(unoGame.getGameState().isSkip());
        assertEquals(0, unoGame.getGameState().getDrawCardsAmount());
        assertNull(unoGame.getGameState().getTopCardColor());
    }

    @Test
    public void givenUnoGameStart_whenDecideFirstPlayer_thenNumberCardsShouldBeBiggest() {
        givenUnoGameStart();

        Player firstPlayer = unoGame.decideFirstPlayer();

        assertEquals(expectedFirstPlayer(), firstPlayer);
    }

    @Test
    public void whenDealFirstCardIsReverseCard_thenGameStateDirectionShouldBeCounterclockwise() {
        Card redReverseCard = new ReverseCard(Color.RED);
        unoGame.dealFirstCard(redReverseCard);

        assertEquals(COUNTERCLOCKWISE, unoGame.getGameState().getDirection());
    }

    @Test
    public void whenDealFirstCard_thenGameStateDirectionShouldBeClockwise() {

        List<Card> excludeReverseAndWildDrawFourCards = Arrays.asList(
                new NumberCard(Color.RED, Number.ONE),
                new SkipCard(Color.RED),
                new DrawTwoCard(Color.RED),
                new WildCard());

        for (Card card : excludeReverseAndWildDrawFourCards) {
            unoGame.dealFirstCard(card);

            assertEquals(CLOCKWISE, unoGame.getGameState().getDirection());
        }
    }

    @Test
    public void whenDealFirstCardIsWildDrawFourCard_thenShouldFail() {
        assertThrows(IllegalStateException.class, () -> unoGame.dealFirstCard(new WildDrawFourCard()));
    }

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

    private void givenFourPlayersJoinUnoGame(int numberOfPlayers) {
        List<Player> expectedPlayers = generatePlayers(numberOfPlayers);
        joinGame(expectedPlayers);
    }

    private void givenUnoGameStart() {
        givenFourPlayersJoinUnoGame(4);
        unoGame.start();
    }

    private Player expectedFirstPlayer() {
        List<TurnMove> turnMoves = unoGame.getTurnMoves();
        return max(turnMoves, comparing(TurnMove::getNumberCard)).getPlayer();
    }
}