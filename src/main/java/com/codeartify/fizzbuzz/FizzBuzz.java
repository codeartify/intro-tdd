package com.codeartify.fizzbuzz;

public class FizzBuzz {

    public String fizzBuzz(int input) {
        if (input % 3 == 0) {
            return "fizz";
        }
        return String.valueOf(input);
    }
}
