package com.codeartify.fizzbuzz;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzShould {
    @Test
    void display_number_if_number_is_divisible_by_2() {
        var fizzBuzz = new FizzBuzz();

        var actual = fizzBuzz.fizzBuzz(2);

        assertEquals("2", actual);
    }

    @ParameterizedTest()
    @ValueSource(ints = {3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 39, 63})
    void display_fizz_if_the_number_is_divisible_by_3(int input) {
        var fizzBuzz = new FizzBuzz();

        var actual = fizzBuzz.fizzBuzz(input);

        assertEquals("fizz", actual);
    }
}
