package com.codeartify;

import java.util.List;

import static com.codeartify.Cell.*;

public class TicTacToe {

    private String currentPlayer = "X";
    private final Board board = new Board();
    private String winner;

    public void play(Cell cell) {
        if (isGameFinished() || board.isMarked(cell)) {
            return;
        }

        mark(cell);
        checkWinner();
        switchPlayers();
    }

    private void mark(Cell cell) {
        this.board.mark(cell, currentPlayer);
    }

    private boolean isGameFinished() {
        return winner != null || isDraw();
    }

    private void checkWinner() {
        this.winner = hasAnyRow() || hasAnyDiagonal() || hasAnyCol() ? currentPlayer : null;
    }

    private boolean hasAnyCol() {
        return occupiesAll(List.of(UPPER_LEFT, CENTER_LEFT, LOWER_LEFT))
                || occupiesAll(List.of(UPPER_CENTER, CENTER, LOWER_CENTER))
                || occupiesAll(List.of(UPPER_RIGHT, CENTER_RIGHT, LOWER_RIGHT));
    }

    private boolean hasAnyDiagonal() {
        return occupiesAll(List.of(UPPER_LEFT, CENTER, LOWER_RIGHT)) || occupiesAll(List.of(LOWER_LEFT, CENTER, UPPER_RIGHT));
    }

    private boolean hasAnyRow() {
        return occupiesAll(List.of(UPPER_LEFT, UPPER_CENTER, UPPER_RIGHT))
                || occupiesAll(List.of(CENTER_LEFT, CENTER, CENTER_RIGHT))
                || occupiesAll(List.of(LOWER_LEFT, LOWER_CENTER, LOWER_RIGHT));
    }

    private boolean occupiesAll(List<Cell> cellsToMatch) {
        return cellsToMatch.stream()
                .map(cell -> markAt(cell).equals(currentPlayer))
                .reduce((x, y) -> x && y)
                .orElse(false);
    }

    private void switchPlayers() {
        this.currentPlayer = this.currentPlayer.equals("O") ? "X" : "O";
    }

    public String currentPlayer() {
        return currentPlayer;
    }

    public String markAt(Cell cell) {
        return board.markAt(cell);
    }

    public String winner() {
        return this.winner;
    }

    public boolean isDraw() {
        return winner == null && board.isFilled();
    }
}
