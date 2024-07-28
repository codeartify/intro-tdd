package com.codeartify.tictactoe;

import java.util.HashMap;
import java.util.Map;

public class Board {
    public static final int NUMBER_OF_CELLS = 9;
    private final Map<Cell, Player> board = new HashMap<>();

    public void mark(Cell cell, Player player) {
        this.board.put(cell, player);
    }

    public Player markAt(Cell cell) {
        return this.board.getOrDefault(cell, Player.EMPTY);
    }

    boolean isMarked(Cell cell) {
        return markAt(cell) != Player.EMPTY;
    }

    public boolean isFilled() {
        return board.size() == NUMBER_OF_CELLS;
    }
}
