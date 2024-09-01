package com.codeartify.exercise6.tictactoe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.codeartify.exercise6.tictactoe.Cell.*;
import static com.codeartify.exercise6.tictactoe.Player.*;

public class TicTacToe {
    public static final int NUMBER_OF_CELLS = 9;
    private final Map<Cell, Player> board = new HashMap<>();

    private Player currentPlayer;
    private Player winner;

    private TicTacToe() {
        currentPlayer = X;
        winner = EMPTY;
    }

    public static TicTacToe create() {
        return new TicTacToe();
    }


    public void play(Cell cell) {
        if (canPlay(cell)) {
            mark(cell);
            selectWinner();
            switchPlayers();
        }
    }

    private boolean canPlay(Cell cell) {
        return !isGameFinished() && !isMarked(cell);
    }

    private boolean isGameFinished() {
        return hasWinner() || isDraw();
    }

    private boolean hasWinner() {
        return winner != EMPTY;
    }

    private boolean isMarked(Cell cell) {
        return board.getOrDefault(cell, EMPTY) != EMPTY;
    }

    private void mark(Cell cell) {
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

    private boolean allMarkedByCurrentPlayer(List<Cell> cellsToMatch) {
        return cellsToMatch.stream()
                .map(cell -> markAt(cell) == currentPlayer)
                .reduce((x, y) -> x && y)
                .orElse(false);
    }

    private void switchPlayers() {
        this.currentPlayer = this.currentPlayer == O ? X : O;
    }

    public Player currentPlayer() {
        return currentPlayer;
    }

    public Player markAt(Cell cell) {
        return this.board.getOrDefault(cell, Player.EMPTY);
    }

    public Player winner() {
        return this.winner;
    }

    public boolean isDraw() {
        return board.size() == NUMBER_OF_CELLS && !hasWinner();
    }
}
