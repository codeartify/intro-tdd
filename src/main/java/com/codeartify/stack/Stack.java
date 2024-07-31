package com.codeartify.stack;

import java.util.ArrayList;
import java.util.List;

public class Stack {

    private int size;
    private final List<Integer> elements = new ArrayList<>();

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(int element) {
        this.elements.add(element);
        size++;
    }

    public int pop() {
        if (size == 0) {
            throw new EmptyStackPoppedException();
        }
        return elements.remove(--size);
    }

    public int size() {
        return size;
    }
}
