import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class BoardTest {

    private val sut = Board()

    @Test
    fun validSolutionTest() {
        assertTrue(true, "Hello")
    }

    @Test
    fun fullBoardNoWinnerTest() {
        assertTrue(sut.isFull(), "Board should be full")
    }
}