class Game(
    private val verbose: Boolean = false
) {
    private val board = Board()

    fun reset() {
        board.reset()
    }

    fun run() {
        reset()
        if (verbose) {
            board.debug()
        }
    }
}