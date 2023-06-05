package domain.game;

import domain.player.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    /*
     * Method Specification:
     *
     * REQUIRES:
     * - A valid `phase` of the game which should be one of the {Phase.Draft, Phase.Attack, Phase.Fortify}.
     * - A valid `players` list which should not be empty.
     * - A valid `currentplayer` that must be present in the `players` list.
     * - A `roundCounter` that should be a non-negative integer.
     *
     * MODIFIES:
     * - The `phase` of the game which is updated based on the current phase.
     * - The `currentplayer` who will be the next player in the `players` list if the current phase becomes 'Draft'.
     * - The `roundCounter` which increments by 1 if the current phase becomes 'Draft' and currentplayer is the last in the `players` list.
     *
     * EFFECTS:
     * - Transitions the game to the next phase. The transition order is from Draft -> Attack -> Fortify -> Draft.
     * - If the phase transitions from Fortify to Draft, the `currentplayer` is updated to the next player in the `players` list.
     * - If the phase transitions from Fortify to Draft and the currentplayer is the last in the `players` list, the `roundCounter` is incremented by 1.
     * - If the phase transitions from Fortify to Draft, the `doDraftPhase()` method is called for the new current player.
     */

    private Game game;

    @BeforeEach
    void setUp() {

        // Setup game
        Game.destroyInstance();
        game = Game.getInstance();
        game.createGameMap();
        game.shareTerritories();

        // Test initial game state
        assertSame(game.getPhase(), Phase.Draft);
        assertEquals(game.getRoundCount(), 0);
        assertSame(game.getCurrentplayer(), game.getPlayers().get(0));
        assertSame(game.getDraftArmies(), Math.floorDiv(game.getCurrentplayer().getTerritoryCount(), 2));

    }

    @Test
    void testAttack() {

        // Move to a new phase
        game.nextPhase();

        // Test new game state
        assertSame(game.getPhase(), Phase.Attack);
        assertSame(game.getCurrentplayer(), game.getPlayers().get(0));

    }

    @Test
    void testFortify() {

        int N = 2;

        // Move to a new phase
        IntStream.rangeClosed(1, N).sequential().forEachOrdered(i -> {
            game.nextPhase();

            // Test new game state
            if (i == N) {
                assertSame(game.getPhase(), Phase.Fortify);
                assertSame(game.getCurrentplayer(), game.getPlayers().get(0));
            }
        });

    }

    @Test
    void testNextDraft() {

        int N = 3;

        // Move to a new phase
        IntStream.rangeClosed(1, N).sequential().forEachOrdered(i -> {
            game.nextPhase();

            // Test new game state
            if (i == N) {
                assertSame(game.getPhase(), Phase.Draft);
                assertSame(game.getCurrentplayer(), game.getPlayers().get(1));
            }
        });

    }

    @Test
    void testNextAttack() {

        int N = 4;

        // Move to a new phase
        IntStream.rangeClosed(1, N).sequential().forEachOrdered(i -> {
            game.nextPhase();

            // Test new game state
            if (i == N) {
                assertSame(game.getPhase(), Phase.Attack);
                assertSame(game.getCurrentplayer(), game.getPlayers().get(1));
            }
        });

    }

    @Test
    void testNextFortify() {

        int N = 5;

        // Move to a new phase
        IntStream.rangeClosed(1, N).sequential().forEachOrdered(i -> {
            game.nextPhase();

            // Test new game state
            if (i == N) {
                assertSame(game.getPhase(), Phase.Fortify);
                assertSame(game.getCurrentplayer(), game.getPlayers().get(1));
            }
        });

    }

    @AfterEach
    void cleanUp() {
        Game.destroyInstance();
        game = null;
    }

}