package com.mak;

import java.util.HashSet;
import java.util.List;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        var list = List.of(6, 100,4,200,1,3,2,5);
        var set = new HashSet<>(list);
        var longest = 0;
        int c1 = 0;
        for(var num : list){
            int c = 1;
            var cNum = num;
            if(!set.contains(cNum - 1)) {
                c1++;
                while (set.contains(cNum + 1)) {
                    cNum++;
                    c++;
                    longest = Math.max(longest, c);
                }
            }
        }
        System.out.println(longest);
        System.out.println(c1);
    }

}
