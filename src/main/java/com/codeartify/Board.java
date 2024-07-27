package com.codeartify;

import java.util.HashMap;
import java.util.Map;

public class Board {
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
        return board.size() == 9;
    }
}
