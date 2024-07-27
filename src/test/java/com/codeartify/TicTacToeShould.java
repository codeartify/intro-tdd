package com.codeartify;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Implement test cases in that specific order
 */
public class TicTacToeShould {
    @Test
    void switch_players_after_playing_free_cell() {
        var ticTacToe = new TicTacToe();

        ticTacToe.play(Cell.CENTER);

        assertEquals("O", ticTacToe.currentPlayer());
    }

    @Test
    void not_switch_players_if_cell_is_already_marked() {
        var ticTacToe = new TicTacToe();

        ticTacToe.play(Cell.CENTER);
        ticTacToe.play(Cell.CENTER);

        assertEquals("O", ticTacToe.currentPlayer());
    }

    @Test
    void mark_free_cell_with_current_player() {
        var ticTacToe = new TicTacToe();
        var currentPlayer = ticTacToe.currentPlayer();

        ticTacToe.play(Cell.CENTER);

        assertEquals(currentPlayer, ticTacToe.markAt(Cell.CENTER));
    }

    @Test
    void not_mark_already_marked_cell_with_currentPlayer() {
        var ticTacToe = new TicTacToe();
        var previousPlayer = ticTacToe.currentPlayer();

        ticTacToe.play(Cell.CENTER);
        ticTacToe.play(Cell.CENTER);

        assertEquals(previousPlayer, ticTacToe.markAt(Cell.CENTER));
    }

    @Test
    void win_if_first_row_is_occupied_by_one_player() {
        var ticTacToe = new TicTacToe();

        ticTacToe.play(Cell.UPPER_LEFT);
        ticTacToe.play(Cell.CENTER_LEFT);
        ticTacToe.play(Cell.UPPER_CENTER);
        ticTacToe.play(Cell.CENTER);
        ticTacToe.play(Cell.UPPER_RIGHT);

        assertEquals("X", ticTacToe.winner());
    }

    @Test
    void win_if_second_row_is_occupied_by_one_player() {
        var ticTacToe = new TicTacToe();

        ticTacToe.play(Cell.UPPER_LEFT);
        ticTacToe.play(Cell.CENTER_LEFT);
        ticTacToe.play(Cell.UPPER_CENTER);
        ticTacToe.play(Cell.CENTER);
        ticTacToe.play(Cell.LOWER_RIGHT);
        ticTacToe.play(Cell.CENTER_RIGHT);

        assertEquals("O", ticTacToe.winner());
    }

    @Test
    void win_if_third_row_is_occupied_by_one_player() {
        var ticTacToe = new TicTacToe();

        ticTacToe.play(Cell.LOWER_LEFT);
        ticTacToe.play(Cell.CENTER_LEFT);
        ticTacToe.play(Cell.LOWER_CENTER);
        ticTacToe.play(Cell.CENTER);
        ticTacToe.play(Cell.LOWER_RIGHT);

        assertEquals("X", ticTacToe.winner());
    }


    @Test
    void win_if_upper_left_lower_right_diagonal_is_marked_by_current_player() {
        var ticTacToe = new TicTacToe();

        ticTacToe.play(Cell.UPPER_LEFT);
        ticTacToe.play(Cell.CENTER_LEFT);
        ticTacToe.play(Cell.CENTER);
        ticTacToe.play(Cell.CENTER_RIGHT);
        ticTacToe.play(Cell.LOWER_RIGHT);

        assertEquals("X", ticTacToe.winner());
    }


    @Test
    void win_if_lower_left_upper_right_diagonal_is_marked_by_current_player() {
        var ticTacToe = new TicTacToe();

        ticTacToe.play(Cell.LOWER_LEFT);
        ticTacToe.play(Cell.CENTER_LEFT);
        ticTacToe.play(Cell.CENTER);
        ticTacToe.play(Cell.CENTER_RIGHT);
        ticTacToe.play(Cell.UPPER_RIGHT);

        assertEquals("X", ticTacToe.winner());
    }



    @Test
    void win_if_first_col_is_marked_by_current_player() {
        var ticTacToe = new TicTacToe();

        ticTacToe.play(Cell.UPPER_LEFT);
        ticTacToe.play(Cell.CENTER);
        ticTacToe.play(Cell.CENTER_LEFT);
        ticTacToe.play(Cell.LOWER_CENTER);
        ticTacToe.play(Cell.LOWER_LEFT);

        assertEquals("X", ticTacToe.winner());
    }


    @Test
    void win_if_second_col_is_marked_by_current_player() {
        var ticTacToe = new TicTacToe();

        ticTacToe.play(Cell.UPPER_CENTER);
        ticTacToe.play(Cell.UPPER_LEFT);
        ticTacToe.play(Cell.CENTER);
        ticTacToe.play(Cell.LOWER_LEFT);
        ticTacToe.play(Cell.LOWER_CENTER);

        assertEquals("X", ticTacToe.winner());
    }




    @Test
    void win_if_third_col_is_marked_by_current_player() {
        var ticTacToe = new TicTacToe();

        ticTacToe.play(Cell.UPPER_RIGHT);
        ticTacToe.play(Cell.UPPER_LEFT);
        ticTacToe.play(Cell.CENTER_RIGHT);
        ticTacToe.play(Cell.LOWER_LEFT);
        ticTacToe.play(Cell.LOWER_RIGHT);

        assertEquals("X", ticTacToe.winner());
    }

    @Test
    void end_in_draw_if_all_cells_occupied_and_no_winner() {
        /*
        * X O X
        * O X X
        * O X O
         */
        var ticTacToe = new TicTacToe();

        ticTacToe.play(Cell.UPPER_LEFT);
        ticTacToe.play(Cell.UPPER_CENTER);
        ticTacToe.play(Cell.UPPER_RIGHT);
        ticTacToe.play(Cell.CENTER_LEFT);
        ticTacToe.play(Cell.CENTER);
        ticTacToe.play(Cell.LOWER_LEFT);
        ticTacToe.play(Cell.CENTER_RIGHT);
        ticTacToe.play(Cell.LOWER_RIGHT);
        ticTacToe.play(Cell.LOWER_CENTER);

        assertTrue(ticTacToe.isDraw());
    }



}
