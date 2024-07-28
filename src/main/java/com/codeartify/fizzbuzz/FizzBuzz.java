package com.codeartify.fizzbuzz;

import org.apache.logging.log4j.util.Strings;

public class FizzBuzz {

    public String fizzBuzz(int input) {
        var concat="";

        if (input % 3 == 0) {
            concat = "fizz";
        }

        if (input % 5 == 0) {
            concat += "buzz";
        }

        if (Strings.isEmpty(concat)) {
            concat = String.valueOf(input);
        }

        return concat;
    }
}
