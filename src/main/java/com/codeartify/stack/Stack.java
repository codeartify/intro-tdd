package com.codeartify.stack;

public class Stack {

     private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(int element) {
        size++;

    }

    public int pop() {
        size--;
        return -1;
    }

    public int size() {
        return size;
    }
}
