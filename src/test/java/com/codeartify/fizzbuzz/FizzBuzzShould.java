package com.codeartify.fizzbuzz;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzShould {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4, 7, 8, 11, 13, 14, 16, 17, 19, 22, 23, 26, 28, 29})
    void display_number_if_number_as_string(int input) {
        var fizzBuzz = new FizzBuzz();

        var actual = fizzBuzz.fizzBuzz(input);

        assertEquals(input + "", actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 9, 12, 18, 21, 24, 27, 39, 63})
    void display_fizz_if_the_number_is_divisible_by_3(int input) {
        var fizzBuzz = new FizzBuzz();

        var actual = fizzBuzz.fizzBuzz(input);

        assertEquals("fizz", actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 20, 25, 35, 40, 50, 55, 65})
    void display_buzz_if_the_number_is_divisible_by_5(int input) {
        var fizzBuzz = new FizzBuzz();

        var actual = fizzBuzz.fizzBuzz(input);

        assertEquals("buzz", actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {15, 30, 45, 60, 75})
    void display_fizzbuzz_if_the_number_is_divisible_by_5_and_3(int input) {
        var fizzBuzz = new FizzBuzz();

        var actual = fizzBuzz.fizzBuzz(input);

        assertEquals("fizzbuzz", actual);
    }
}
