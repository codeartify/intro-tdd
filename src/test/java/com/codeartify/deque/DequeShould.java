package com.codeartify.deque;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DequeShould {
    @Test
    void be_empty_on_initialisation() {
        var deque = new Deque();

        assertTrue(deque.isEmpty());
        assertEquals(0, deque.size());
    }

    @Test
    void not_be_empty_after_adding_an_element_to_the_front() {
        var deque = new Deque();

        deque.addFront(1);

        assertFalse(deque.isEmpty());
        assertEquals(1, deque.size());
    }

    @Test
    void be_empty_after_adding_and_removing_an_element_to_and_from_the_front() {
        var deque = new Deque();

        deque.addFront(1);
        deque.removeFront();

        assertTrue(deque.isEmpty());
        assertEquals(0, deque.size());
    }

    @Test
    void throw_an_exception_when_trying_to_remove_front_from_an_empty_deque() {
        assertThrows(DequeEmptyException.class, () -> new Deque().removeFront());
    }


    @Test
    void not_be_empty_after_adding_an_element_to_the_rear() {
        var deque = new Deque();

        deque.addRear(1);

        assertFalse(deque.isEmpty());
        assertEquals(1, deque.size());
    }

    @Test
    void be_empty_after_adding_and_removing_an_element_to_and_from_the_rear() {
        var deque = new Deque();

        deque.addRear(1);
        deque.removeRear();

        assertTrue(deque.isEmpty());
        assertEquals(0, deque.size());
    }

    @Test
    void throw_an_exception_when_trying_to_remove_rear_from_an_empty_deque() {
        assertThrows(DequeEmptyException.class, () -> new Deque().removeRear());
    }

    @Test
    void contain_two_elements_after_adding_two_elements_to_the_front() {
        var deque = new Deque();

        deque.addFront(1);
        deque.addFront(1);

        assertFalse(deque.isEmpty());
        assertEquals(2, deque.size());
    }

    @Test
    void pop_elements_from_front_in_reverse_insertion_order() {

    }

}
