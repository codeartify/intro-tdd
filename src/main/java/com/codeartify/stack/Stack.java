package com.codeartify.stack;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
    private final List<T> elements = new ArrayList<>();

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public void push(T element) {
        this.elements.add(element);
    }

    public T pop() {
        if (elements.isEmpty()) {
            throw new EmptyStackPoppedException();
        }
        return elements.removeLast();
    }

    public int size() {
        return elements.size();
    }
}
