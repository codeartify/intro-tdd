package com.codeartify.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StackShould {

    @Test
    void be_empty_on_creation() {
        var stack = new Stack();

        var isEmpty = stack.isEmpty();

        assertTrue(isEmpty);
    }

    @Test
    void not_be_empty_after_pushing_an_element() {
        var stack = new Stack();

        stack.push(0);

        assertFalse(stack.isEmpty());
    }

    @Test
    void be_empty_after_pushing_and_popping_an_element() {
        var stack = new Stack();

        stack.push(0);
        stack.pop();

        assertTrue(stack.isEmpty());
    }
}
