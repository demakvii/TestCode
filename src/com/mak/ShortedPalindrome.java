package com.mak;

import java.util.TreeMap;

public class ShortedPalindrome {

    public static void main(String[] args) {
        //System.out.println(getSmallestPalindrome("a?rt???"));
        //System.out.println(getSmallestPalindrome("yh??tx"));
        System.out.println(getSmallestPalindrome("axxb??"));
    }

    public static String getSmallestPalindrome(String s) {
        // Write your code here
        var sArr = s.split("");
        var countQ = 0;
        var wordMap = new TreeMap<String, Integer>();
        for(var ch : sArr){
            if(ch.equals("?"))
                countQ++;
            else {
                var value = 0;
                if(wordMap.containsKey(ch)) {
                    value = wordMap.get(ch);
                }
                wordMap.put(ch, ++value);
            }
        }
        if(wordMap.size() - countQ > 1) {
            return "-1";
        }
        var pCountQ = 0;
        var sb = new StringBuilder();
        String firstWord = null;
        for(var entry :  wordMap.entrySet()){
            var iCount = entry.getValue();
            if(firstWord == null){
                firstWord = entry.getKey();
            }
            pCountQ += iCount;
            while(iCount > 0){
                sb.append(entry.getKey());
                iCount--;
            }
        }


/*        if(pCountQ > countQ) {
            return "-1";
        }*/
        System.out.println(firstWord);
        System.out.println(pCountQ);
        System.out.println(sb);
        System.out.println(countQ);
        System.out.println(wordMap);

        StringBuilder unfinishedStr;
        if(sb.length() % 2 == 0){
            unfinishedStr = sb.append(sb.reverse());
        } else {
            var firstHalf = sb.toString();
            var secondHalf = sb.reverse().deleteCharAt(0).toString();
            unfinishedStr = new StringBuilder(firstHalf).append(secondHalf);
        }

        while (unfinishedStr.length() != s.length()){
            unfinishedStr.insert(0, firstWord);
            unfinishedStr.append(firstWord);
        }
        System.out.println(unfinishedStr);
        return unfinishedStr.toString();
    }
}
