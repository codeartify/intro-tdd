package com.codeartify;

import java.util.List;

import static com.codeartify.Cell.*;
import static com.codeartify.Player.*;

public class TicTacToe {
    private final Board board;
    private Player currentPlayer = X;
    private Player winner = EMPTY;

    public TicTacToe(Board board) {
        this.board = board;
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
        return board.isMarked(cell);
    }

    private void mark(Cell cell) {
        this.board.mark(cell, currentPlayer);
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
        return board.markAt(cell);
    }

    public Player winner() {
        return this.winner;
    }

    public boolean isDraw() {
        return board.isFilled() && !hasWinner();
    }
}
