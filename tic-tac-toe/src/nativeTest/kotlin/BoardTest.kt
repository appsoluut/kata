import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BoardTest {

    private val sut = Board()

    @BeforeTest
    fun beforeEach() {
        sut.reset()
    }

    @Test
    fun winnerBeforeTheBoardIsFullTest() {
        // X X O
        // X   O
        //     O
        sut.set(Player.X, 0, 0)
        sut.set(Player.X, 0, 1)
        sut.set(Player.X, 1, 0)
        sut.set(Player.O, 2, 0)
        sut.set(Player.O, 2, 1)
        sut.set(Player.O, 2, 2)
        assertFalse(sut.isFull(), "Board should not be full yet")
        assertEquals(Player.O, sut.hasWinner(), "Player.O should have won")
    }

    @Test
    fun noWinnerTest() {
        // Board with just one move
        sut.set(Player.X, 0, 0)
        assertFalse(sut.isFull(), "Board should not be full yet")
        assertEquals(null, sut.hasWinner(), "No player should have won yet")
    }

    @Test
    fun detectFullBoardTest() {
        // X O O
        // O X O
        // X O X
        sut.set(Player.X, 0, 0)
        sut.set(Player.O, 1, 0)
        sut.set(Player.O, 2, 0)
        sut.set(Player.O, 0, 1)
        sut.set(Player.X, 1, 1)
        sut.set(Player.O, 2, 1)
        sut.set(Player.X, 0, 2)
        sut.set(Player.O, 1, 2)
        sut.set(Player.X, 2, 2)
        assertTrue(sut.isFull(), "Board should be full")
    }

    @Test
    fun detectBoardNotYetFullTest() {
        // Board with just one move
        sut.set(Player.X, 0, 0)
        assertFalse(sut.isFull(), "Board should not be full yet")
    }

    @Test
    fun fullBoardWithWinnerTest() {
        // X O O
        // O X O
        // X O X
        sut.set(Player.X, 0, 0)
        sut.set(Player.O, 1, 0)
        sut.set(Player.O, 2, 0)
        sut.set(Player.O, 0, 1)
        sut.set(Player.X, 1, 1)
        sut.set(Player.O, 2, 1)
        sut.set(Player.X, 0, 2)
        sut.set(Player.O, 1, 2)
        sut.set(Player.X, 2, 2)
        assertTrue(sut.isFull(), "Board should be full")
        assertEquals(Player.X, sut.hasWinner(), "Player.X should have won")
    }

    @Test
    fun fullBoardNoWinnerTest() {
        // X O O
        // O X X
        // X O O
        sut.set(Player.X, 0, 0)
        sut.set(Player.O, 1, 0)
        sut.set(Player.O, 2, 0)
        sut.set(Player.O, 0, 1)
        sut.set(Player.X, 1, 1)
        sut.set(Player.X, 2, 1)
        sut.set(Player.X, 0, 2)
        sut.set(Player.O, 1, 2)
        sut.set(Player.O, 2, 2)
        assertTrue(sut.isFull(), "Board should be full")
        assertEquals(null, sut.hasWinner(), "No player should have won")
    }
}