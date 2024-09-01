package com.codeartify.exercise6.stack;


public class Stack {

    private int size;
    private int element;

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(int element) {
        this.element = element;
        size++;
    }

    public int pop() {
        if (size == 0) {
            throw new EmptyStackPoppedException();
        }
        size--;
        return element;
    }

    public int size() {
        return size;
    }
}

