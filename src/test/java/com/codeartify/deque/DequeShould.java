package com.codeartify.deque;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DequeShould {
    @Test
    void be_empty_on_initialisation() {
        var deque = new Deque();

        assertTrue(deque.isEmpty());
    }
}
