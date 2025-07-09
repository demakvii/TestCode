package com.mak;

public class CountSubStringNoRep {

    public static void main(String[] args) {
        var str = "abca";
        //a b ab c bc abc a ca bca
        var freqMap = new int[26];
        int count = 0;
        for(int i = 0, j=0; i<str.length(); i++){
            var selectedCh = str.charAt(i) - 'a';
            ++freqMap[selectedCh];
            while (freqMap[selectedCh] > 1){
                --freqMap[str.charAt(j++) - 'a'];
            }
            count += i - j + 1;
        }
        System.out.println(count);
    }

}
