package com.mak;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DuplicateStringJava8 {

    public static void main(String[] args) {
        var str =  "ABASDSD";
        var output = Stream.of(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(t -> t.getValue() > 1).map(Map.Entry::getKey)
                .collect(Collectors.joining());

        System.out.println(output);

        output = Stream.of(str.split("")).collect(Collectors.groupingBy(t -> t,
                        Collectors.collectingAndThen(Collectors.counting(), t -> t > 1)))
                .entrySet().stream().filter(Map.Entry::getValue).map(Map.Entry::getKey).collect(Collectors.joining());

        System.out.println(output);

    }
}
