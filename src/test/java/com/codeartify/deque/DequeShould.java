package com.codeartify.deque;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DequeShould {
    @Test
    void be_empty_on_initialisation() {
        var deque = new Deque();

        assertTrue(deque.isEmpty());
    }

    @Test
    void not_be_empty_after_adding_an_element_to_the_front() {
        var deque = new Deque();

        deque.addFront(1);

        assertFalse(deque.isEmpty());
    }


}
