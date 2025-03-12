class Game(
    private val verbose: Boolean = false
) {
    private val board = Board()
    private var player = Player.X

    private fun reset() {
        board.reset()
    }

    private fun changePlayer() {
        player = if (player == Player.X) Player.O else Player.X
    }

    fun run() {
        reset()

        val positions = MutableList(9) { it }

        do {
            val position = positions.random()
            positions.remove(position)

            val row = position / 3
            val col = position % 3
            board.set(player, col, row)

            if (verbose) {
                board.print()
                println()
            }

            changePlayer()
        } while (!board.isFull() && board.hasWinner() == null && positions.isNotEmpty())

        val winner = board.hasWinner()

        if (!verbose) {
            // Only draw the board again in the last step if not verbose
            board.print()
        }

        winner?.let {
            println("*** Player $it wins! ***")
        } ?: println("*** Nobody won ***")
    }
}