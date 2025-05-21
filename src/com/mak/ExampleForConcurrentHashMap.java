package com.mak;

import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

public class ExampleForConcurrentHashMap {

    public static void main(String[] args) {
       var charMap = new ConcurrentHashMap<String, Integer>();

        IntStream.iterate('a', i -> i <= 'z', i -> ++i)
                .forEach(t -> charMap.put(String.valueOf((char)t), 1));

        System.out.println(charMap);

        Runnable r = () -> {
            for (var char1 : charMap.entrySet()){
                charMap.put(char1.getKey() + char1.getKey(), 1);
            }
            System.out.println("______________________");
            for (var char1 : charMap.entrySet()){
                System.out.println(char1);
            }
        };
        var thread = new Thread(r);
        thread.start();

        for (var char1 : charMap.entrySet()){
            System.out.println(char1);
        }

    }
}
