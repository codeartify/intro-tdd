package com.codeartify.exercise8.tictactoe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
 

public class TicTacToe2Should {
    @Test
    void switch_players_after_playing_free_cell() {
        var ticTacToe = TicTacToe2.create();

        ticTacToe.play(Cell2.CENTER);

        Assertions.assertEquals(Player2.O, ticTacToe.currentPlayer());
    }

    @Test
    void not_switch_players_if_cell_is_already_marked() {
        var ticTacToe = TicTacToe2.create();

        ticTacToe.play(Cell2.CENTER);
        ticTacToe.play(Cell2.CENTER);

        assertEquals(Player2.O, ticTacToe.currentPlayer());
    }

    @Test
    void mark_free_cell_with_current_player() {
        var ticTacToe = TicTacToe2.create();
        var currentPlayer = ticTacToe.currentPlayer();

        ticTacToe.play(Cell2.CENTER);

        assertEquals(currentPlayer, ticTacToe.markAt(Cell2.CENTER));
    }

    @Test
    void not_mark_already_marked_cell_with_currentPlayer() {
        var ticTacToe = TicTacToe2.create();
        var previousPlayer = ticTacToe.currentPlayer();

        ticTacToe.play(Cell2.CENTER);
        ticTacToe.play(Cell2.CENTER);

        assertEquals(previousPlayer, ticTacToe.markAt(Cell2.CENTER));
    }

    @Test
    void be_won_if_first_row_is_marked_by_one_player() {
        var ticTacToe = TicTacToe2.create();

        ticTacToe.play(Cell2.UPPER_LEFT);
        ticTacToe.play(Cell2.CENTER_LEFT);
        ticTacToe.play(Cell2.UPPER_CENTER);
        ticTacToe.play(Cell2.CENTER);
        ticTacToe.play(Cell2.UPPER_RIGHT);

        assertEquals(Player2.X, ticTacToe.winner());
    }

    @Test
    void be_won_if_second_row_is_marked_by_one_player() {
        var ticTacToe = TicTacToe2.create();

        ticTacToe.play(Cell2.UPPER_LEFT);
        ticTacToe.play(Cell2.CENTER_LEFT);
        ticTacToe.play(Cell2.UPPER_CENTER);
        ticTacToe.play(Cell2.CENTER);
        ticTacToe.play(Cell2.LOWER_RIGHT);
        ticTacToe.play(Cell2.CENTER_RIGHT);

        assertEquals(Player2.O, ticTacToe.winner());
    }

    @Test
    void be_won_if_third_row_is_marked_by_one_player() {
        var ticTacToe = TicTacToe2.create();

        ticTacToe.play(Cell2.LOWER_LEFT);
        ticTacToe.play(Cell2.CENTER_LEFT);
        ticTacToe.play(Cell2.LOWER_CENTER);
        ticTacToe.play(Cell2.CENTER);
        ticTacToe.play(Cell2.LOWER_RIGHT);

        assertEquals(Player2.X, ticTacToe.winner());
    }


    @Test
    void be_won_if_upper_left_lower_right_diagonal_is_marked_by_current_player() {
        var ticTacToe = TicTacToe2.create();

        ticTacToe.play(Cell2.UPPER_LEFT);
        ticTacToe.play(Cell2.CENTER_LEFT);
        ticTacToe.play(Cell2.CENTER);
        ticTacToe.play(Cell2.CENTER_RIGHT);
        ticTacToe.play(Cell2.LOWER_RIGHT);

        assertEquals(Player2.X, ticTacToe.winner());
    }


    @Test
    void be_won_if_lower_left_upper_right_diagonal_is_marked_by_current_player() {
        var ticTacToe = TicTacToe2.create();

        ticTacToe.play(Cell2.LOWER_LEFT);
        ticTacToe.play(Cell2.CENTER_LEFT);
        ticTacToe.play(Cell2.CENTER);
        ticTacToe.play(Cell2.CENTER_RIGHT);
        ticTacToe.play(Cell2.UPPER_RIGHT);

        assertEquals(Player2.X, ticTacToe.winner());
    }


    @Test
    void be_won_if_first_col_is_marked_by_current_player() {
        var ticTacToe = TicTacToe2
                .create();

        ticTacToe.play(Cell2.UPPER_LEFT);
        ticTacToe.play(Cell2.CENTER);
        ticTacToe.play(Cell2.CENTER_LEFT);
        ticTacToe.play(Cell2.LOWER_CENTER);
        ticTacToe.play(Cell2.LOWER_LEFT);

        assertEquals(Player2.X, ticTacToe.winner());
    }


    @Test
    void be_won_if_second_col_is_marked_by_current_player() {
        var ticTacToe = TicTacToe2.create();

        ticTacToe.play(Cell2.UPPER_CENTER);
        ticTacToe.play(Cell2.UPPER_LEFT);
        ticTacToe.play(Cell2.CENTER);
        ticTacToe.play(Cell2.LOWER_LEFT);
        ticTacToe.play(Cell2.LOWER_CENTER);

        assertEquals(Player2.X, ticTacToe.winner());
    }


    @Test
    void be_won_if_third_col_is_marked_by_current_player() {
        var ticTacToe = TicTacToe2.create();

        ticTacToe.play(Cell2.UPPER_RIGHT);
        ticTacToe.play(Cell2.UPPER_LEFT);
        ticTacToe.play(Cell2.CENTER_RIGHT);
        ticTacToe.play(Cell2.LOWER_LEFT);
        ticTacToe.play(Cell2.LOWER_RIGHT);

        assertEquals(Player2.X, ticTacToe.winner());
    }

    @Test
    void end_in_a_draw_if_all_cells_marked_and_no_winner() {
        var ticTacToe = TicTacToe2.create();

        ticTacToe.play(Cell2.UPPER_LEFT);
        ticTacToe.play(Cell2.UPPER_CENTER);
        ticTacToe.play(Cell2.UPPER_RIGHT);
        ticTacToe.play(Cell2.CENTER_LEFT);
        ticTacToe.play(Cell2.CENTER);
        ticTacToe.play(Cell2.LOWER_LEFT);
        ticTacToe.play(Cell2.CENTER_RIGHT);
        ticTacToe.play(Cell2.LOWER_RIGHT);
        ticTacToe.play(Cell2.LOWER_CENTER);

        assertTrue(ticTacToe.isDraw());
    }


}
