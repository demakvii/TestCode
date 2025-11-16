package com.mak;

public class LongestPalindrome {

    public static void main(String[] args) {
        result("babad");
        result("cbbd");
    }

    private static void result(String str) {
        var strArr = str.split("");
        String result = "";
        for(int i = 0; i < strArr.length; i++) {
            int left = i ;
            int right = i;
            while ((left >= 0 && right < strArr.length) && (strArr[left].equals(strArr[right]))){
                if(right - left + 1 > result.length()){
                    result = str.substring(left, right + 1);
                }
                left--;
                right++;
            }
            left = i;
            right = i + 1;
            while ((left >= 0 && right < strArr.length) && (strArr[left].equals(strArr[right]))){
                if(right - left + 1 > result.length()){
                    result = str.substring(left, right + 1);
                }
                left--;
                right++;
            }

        }
        System.out.println(result);
    }

}
