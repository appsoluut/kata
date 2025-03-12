class Board {
    private val board = MutableList(3) { MutableList<Player?>(3) { null } }

    fun print() {
        println("Board:")
        board.forEach { row ->
            println(row.joinToString(
                separator = " | ",
                transform = { player ->
                    player?.toString() ?: " "
                }
            ))
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
        // Check rows
        board.forEach { row ->
            Player.entries.forEach { player ->
                if (row.all { it == player }) {
                    return player
                }
            }
        }

        // Check columns
        for (row in 0..2) {
            Player.entries.forEach { player ->
                if (board.all { it[row] == player }) {
                    return player
                }
            }
        }

        // Check diagonals
        Player.entries.forEach { player ->
            if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
                return player
            }
            if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
                return player
            }
        }

        return null
    }
}