package com.codeartify.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StackShould {

    @Test
    void be_empty_on_creation() {
        var stack = new Stack();

        var isEmpty = stack.isEmpty();

        assertTrue(isEmpty);
    }
}
