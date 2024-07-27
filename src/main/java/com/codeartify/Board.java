package com.codeartify;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private Map<Cell, String> board = new HashMap<>();

    public void mark(Cell cell, String currentPlayer) {
        this.board.put(cell, currentPlayer);
    }

    public String markAt(Cell cell) {
        return this.board.getOrDefault(cell, "EMPTY");
    }

    boolean isMarked(Cell cell) {
        return !markAt(cell).equals("EMPTY");
    }

    public boolean isFilled() {
        return board.size() == 9;
    }
}
