package com.mak;

import java.util.Arrays;

public class FindNumStartByOne {

    public static void main(String[] args) {
        var list = Arrays.asList(1,2,12,3,23,144,500);

        list.stream().map(String::valueOf).filter(t -> t.startsWith("1"))
                .map(Integer::valueOf).forEach(System.out::println);

    }
}
