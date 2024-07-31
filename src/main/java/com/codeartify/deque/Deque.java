package com.codeartify.deque;

public class Deque {

    private int size = 0;
    private boolean isEmpty = true;

    public boolean isEmpty() {
        return isEmpty;
    }

    public void addFront(int i) {
        isEmpty = false;
        size++;
    }

    public void removeFront() {
        if (isEmpty) {
            throw new DequeEmptyException();
        }
        isEmpty = true;
        size--;
    }

    public int size() {
        return size;
    }
}
