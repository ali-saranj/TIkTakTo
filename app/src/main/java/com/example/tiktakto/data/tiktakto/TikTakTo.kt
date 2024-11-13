package com.example.tiktakto.data.tiktakto

import kotlin.random.Random

class TikTakTo {

    // 1 = O, 2 = X
    var board = arrayOf(
        arrayOf(0, 0, 0),
        arrayOf(0, 0, 0),
        arrayOf(0, 0, 0)
    )

    var player = 1 // 1 represents 'O', 2 represents 'X'

    fun printBoard(): String {
        var mapBoard = ""
        for (row in board) {
            mapBoard += row.joinToString(" | ") { when (it) {
                1 -> "O"
                2 -> "X"
                else -> "_"
            }} + "\n"
        }
        return mapBoard.trimEnd()
    }

    fun checkWin(): Boolean {
        for (i in 0..2) {
            // Check rows and columns
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)
            ) return true
        }
        // Check diagonals
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player)
    }

    fun checkDraw(): Boolean {
        return board.flatten().none { it == 0 } && !checkWin()
    }

    fun getAllItems(): Array<Int> {
        return board.flatten().toTypedArray()
    }

    fun makeMove(index: Int) {
        val row = index / 3
        val col = index % 3
        if (board[row][col] == 0) {
            board[row][col] = player
            if (!checkWin()) player = if (player == 1) 2 else 1
        }
    }

    fun computerMove() {
        val emptyCells = mutableListOf<Pair<Int, Int>>()

        // Find all empty cells
        for (i in 0..2) {
            for (j in 0..2) {
                if (board[i][j] == 0) {
                    emptyCells.add(Pair(i, j))
                }
            }
        }

        // Choose a random cell from the empty cells
        if (emptyCells.isNotEmpty()) {
            val (row, col) = emptyCells[Random.nextInt(emptyCells.size)]
            board[row][col] = player
            if (!checkWin()) player = if (player == 1) 2 else 1
        }
    }
}

fun main() {
    val game = TikTakTo()

    // Test 1: Empty board - should return false
    println("Test 1: Empty board (Expect false) -> ${game.checkDraw()}")

    // Test 2: Winning condition - should return false
    game.board = arrayOf(
        arrayOf(1, 1, 1),
        arrayOf(2, 2, 0),
        arrayOf(0, 0, 0)
    )
    println("Test 2: Winning condition (Expect false) -> ${game.checkDraw()}")

    // Test 3: Full board, no winner - should return true
    game.board = arrayOf(
        arrayOf(1, 2, 1),
        arrayOf(1, 1, 2),
        arrayOf(2, 1, 2)
    )
    println("Test 3: Full board, no winner (Expect true) -> ${game.checkDraw()}")

    // Test 4: Full board, with a winner - should return false
    game.board = arrayOf(
        arrayOf(1, 2, 1),
        arrayOf(1, 1, 1),
        arrayOf(2, 1, 2)
    )
    println("Test 4: Full board, with a winner (Expect false) -> ${game.checkDraw()}")
}
