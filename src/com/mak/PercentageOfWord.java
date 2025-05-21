package com.mak;

import java.util.List;
import java.util.stream.Collectors;

public class PercentageOfWord {

    public static void main(String[] args) {
        var input = List.of("FOO", "FOO", "FOO", "FOO", "FOO", "BAR", "BAR", "BAZ", "BAZ", "BAZ", "DOO",
                "DOO", "TEST");

        var output = input.stream().collect(Collectors.groupingBy(t -> t, Collectors.
                collectingAndThen(Collectors.counting(), count -> (count * 1.0f / input.size()) * 100 )));

        System.out.println(output);
    }
}
