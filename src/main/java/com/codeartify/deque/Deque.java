package com.codeartify.deque;

public class Deque {

    private boolean isEmpty = true;

    public boolean isEmpty() {
        return isEmpty;
    }

    public void addFront(int i) {
        isEmpty = false;
    }

    public void removeFront() {
        if (isEmpty) {
            throw new DequeEmptyException();
        }
        isEmpty = true;
    }
}
