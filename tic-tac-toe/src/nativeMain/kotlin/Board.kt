class Board {
    private val board = MutableList(3) { MutableList<Player?>(3) { null } }

    fun debug() {
        println("Board:")
        board.forEach { row ->
            println(row.joinToString(" | "))
        }
    }

    fun reset() {
        for (i in 0..2) {
            for (j in 0..2) {
                board[i][j] = null
            }
        }
    }

    fun set(player: Player, x: Int, y: Int) {
        board[y][x] = player
    }

    fun isFull(): Boolean {
        board.forEach { row ->
            if (row.any { it == null }) {
                return false
            }
        }
        return true
    }

    fun hasWinner(): Player? {
        return null
    }
}