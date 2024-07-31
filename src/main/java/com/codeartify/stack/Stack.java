package com.codeartify.stack;

public class Stack {

    private boolean isEmpty = true;

    public boolean isEmpty() {
        return isEmpty;
    }

    public void push(int element) {
        this.isEmpty = false;

    }
}
