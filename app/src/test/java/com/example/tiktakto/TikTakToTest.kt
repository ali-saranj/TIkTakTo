package com.example.tiktakto

import com.example.tiktakto.data.tiktakto.TikTakTo
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class TikTakToTest {

    private lateinit var game: TikTakTo

    @Before
    fun setUp() {
        game = TikTakTo()
    }

    @Test
    fun testMakeMove() {
        game.makeMove(0) // Player 1 places on top-left corner
        assertEquals("Expected player 1 mark", 1, game.board[0][0])

        game.makeMove(1) // Player 2 places on top-center
        assertEquals("Expected player 2 mark", 2, game.board[0][1])

        // Check that it switches back to player 1
        assertEquals("Expected player 1's turn", 1, game.player)
    }

    @Test
    fun testComputerMove() {
        game.computerMove()
        val hasMove = game.board.any { row -> row.any { it != 0 } }
        assertTrue("Expected computer to make a move", hasMove)

        // Ensure that player switched after computer's move
        val expectedNextPlayer = if (game.player == 1) 2 else 1
        game.computerMove()
        assertEquals(
            "Expected player to switch after computer move",
            expectedNextPlayer,
            game.player
        )
    }

    @Test
    fun testCheckWin() {
        game.board = arrayOf(
            arrayOf(1, 1, 1),
            arrayOf(0, 2, 0),
            arrayOf(2, 0, 2)
        )
        game.player = 1
        assertTrue("Expected a win for player 1", game.checkWin())

        game.board = arrayOf(
            arrayOf(2, 1, 0),
            arrayOf(2, 1, 0),
            arrayOf(2, 0, 1)
        )
        game.player = 2
        assertTrue("Expected a win for player 2", game.checkWin())
    }

    @Test
    fun testCheckDraw() {
        // A draw board (fully filled, no winner)
        game.board = arrayOf(
            arrayOf(1, 2, 1),
            arrayOf(2, 1, 2),
            arrayOf(2, 1, 2)
        )
        assertTrue("Expected a draw", game.checkDraw())

        // Not a draw (empty cells)
        game.board = arrayOf(
            arrayOf(1, 0, 1),
            arrayOf(2, 1, 2),
            arrayOf(2, 1, 2)
        )
        assertFalse("Expected no draw due to empty cell", game.checkDraw())
    }
}
