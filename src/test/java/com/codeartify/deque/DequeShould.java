package com.codeartify.deque;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void be_empty_after_adding_and_removing_an_element_to_and_from_the_front() {
        var deque = new Deque();

        deque.addFront(1);
        deque.removeFront();

        assertTrue(deque.isEmpty());
    }

    @Test
    void throw_an_exception_when_trying_to_remove_front_from_an_empty_deque() {
        assertThrows(DequeEmptyException.class, () -> new Deque().removeFront());
    }


}
