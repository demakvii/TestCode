package com.mak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public static void main(String[] args) {
        var list = List.of("Caat", "taac", "tan", "nat", "tic");


        //incorrect approach
        var result = list.stream().collect(Collectors.groupingBy(t -> t.chars().sum()));
        System.out.println(result.values());

        //Best approach
        Map<String, List<String>> groupedWords = new HashMap<>();
        for(var word : list){
            var normalizedWord = word.toLowerCase();
            int[] charArr = new int[26];
            for(int i = 0 ; i < normalizedWord.length(); i++){
                charArr[normalizedWord.charAt(i) - 'a']++;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for(int charEle : charArr){
                stringBuilder.append(charEle);
            }
            var key = stringBuilder.toString();
            System.out.println(key);
            List<String> words;
            if(!groupedWords.containsKey(key)){
                words = new ArrayList<>();
            }else {
                words = groupedWords.get(key);
            }
            words.add(word);
            groupedWords.put(key, words);
        }
        System.out.println(groupedWords.values());
    }
}
