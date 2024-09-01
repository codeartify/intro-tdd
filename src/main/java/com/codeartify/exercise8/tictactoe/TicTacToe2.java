package com.codeartify.exercise8.tictactoe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.codeartify.exercise8.tictactoe.Cell2.*;
import static com.codeartify.exercise8.tictactoe.Player2.*;


public class TicTacToe2 {
    public static final int NUMBER_OF_CELLS = 9;
    private final Map<Cell2, Player2> board = new HashMap<>();

    private Player2 currentPlayer;
    private Player2 winner;

    private TicTacToe2() {
        currentPlayer = X;
        winner = EMPTY;
    }

    public static TicTacToe2 create() {
        return new TicTacToe2();
    }


    public void play(Cell2 cell) {
        if (canPlay(cell)) {
            mark(cell);
            selectWinner();
            switchPlayers();
        }
    }

    private boolean canPlay(Cell2 cell) {
        return !isGameFinished() && !isMarked(cell);
    }

    private boolean isGameFinished() {
        return hasWinner() || isDraw();
    }

    private boolean hasWinner() {
        return winner != EMPTY;
    }

    private boolean isMarked(Cell2 cell) {
        return board.getOrDefault(cell, EMPTY) != EMPTY;
    }

    private void mark(Cell2 cell) {
        this.board.put(cell, currentPlayer);
    }

    private void selectWinner() {
        this.winner = hasCurrentPlayerWon() ? currentPlayer : EMPTY;
    }

    private boolean hasCurrentPlayerWon() {
        return hasAnyRow() || hasAnyDiagonal() || hasAnyCol();
    }

    private boolean hasAnyRow() {
        return allMarkedByCurrentPlayer(List.of(UPPER_LEFT, UPPER_CENTER, UPPER_RIGHT))
                || allMarkedByCurrentPlayer(List.of(CENTER_LEFT, CENTER, CENTER_RIGHT))
                || allMarkedByCurrentPlayer(List.of(LOWER_LEFT, LOWER_CENTER, LOWER_RIGHT));
    }

    private boolean hasAnyDiagonal() {
        return allMarkedByCurrentPlayer(List.of(UPPER_LEFT, CENTER, LOWER_RIGHT))
                || allMarkedByCurrentPlayer(List.of(LOWER_LEFT, CENTER, UPPER_RIGHT));
    }

    private boolean hasAnyCol() {
        return allMarkedByCurrentPlayer(List.of(UPPER_LEFT, CENTER_LEFT, LOWER_LEFT))
                || allMarkedByCurrentPlayer(List.of(UPPER_CENTER, CENTER, LOWER_CENTER))
                || allMarkedByCurrentPlayer(List.of(UPPER_RIGHT, CENTER_RIGHT, LOWER_RIGHT));
    }

    private boolean allMarkedByCurrentPlayer(List<Cell2> cellsToMatch) {
        return cellsToMatch.stream()
                .map(cell -> markAt(cell) == currentPlayer)
                .reduce((x, y) -> x && y)
                .orElse(false);
    }

    private void switchPlayers() {
        this.currentPlayer = this.currentPlayer == O ? X : O;
    }

    public Player2 currentPlayer() {
        return currentPlayer;
    }

    public Player2 markAt(Cell2 cell) {
        return this.board.getOrDefault(cell, EMPTY);
    }

    public Player2 winner() {
        return this.winner;
    }

    public boolean isDraw() {
        return board.size() == NUMBER_OF_CELLS && !hasWinner();
    }
}
