package com.mak;

import java.util.List;
import java.util.stream.IntStream;

public class TestMain1 {


    //1,2,3 -> 6
    //1,1,4 -> 4
    public static void main(String[] args) {
        boolean pass = true;
        var n = 3;
        var list = List.of(List.of(1,2,3),List.of(2, 3, 1),List.of(3, 2, 1));
        var total = IntStream.iterate(1, t -> t <= n, operand -> ++operand).reduce(1, (a,b) -> a * b);
        System.out.println(total);
        for(var item : list){
            if (item.size() != n) {
                pass = false;
                break;
            }

            var itemTotal = item.stream().reduce(1, (a,b) -> a * b);
            if (itemTotal != total){
                pass = false;
                break;
            }
        }

        if (pass)
            System.out.println("Perfect list");
        else
            System.out.println("Failed list");
    }
}
