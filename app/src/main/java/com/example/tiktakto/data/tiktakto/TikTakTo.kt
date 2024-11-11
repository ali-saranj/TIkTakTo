package com.example.tiktakto.data.tiktakto

import kotlin.random.Random

class TikTakTo {
    var board = arrayOf(
        arrayOf("", "", ""),
        arrayOf("", "", ""),
        arrayOf("", "", "")
    )

    fun printBoard(): String {
        var mapboard = ""
        for (row in board) {
            mapboard += row.joinToString(" | ") { if (it == "") "_" else it } + "\n"
        }
        return mapboard.trimEnd() // Remove the last newline for a cleaner output
    }


    var player = "X"

    fun checkWin(): Boolean {
        for (i in 0..2) {
            // Check row
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true
            // Check column
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true
        }

        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true

        // No win found
        return false
    }

    fun makeMove(row: Int, col: Int) {
        if (board[row][col] == "") {
            board[row][col] = player
            player = if (player == "X") "O" else "X"
        }
    }

    fun computerMove() {
        val emptyCells = mutableListOf<Pair<Int, Int>>()

        // Find all empty cells
        for (i in 0..2) {
            for (j in 0..2) {
                if (board[i][j] == "") {
                    emptyCells.add(Pair(i, j))
                }
            }
        }

        // Choose a random cell from the empty cells
        if (emptyCells.isNotEmpty()) {
            val (row, col) = emptyCells[Random.nextInt(emptyCells.size)]
            board[row][col] = player
            player = if (player == "X") "O" else "X"
        }
    }

}

fun main() {


}