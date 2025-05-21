package com.mak;

import java.util.Arrays;

public class ReverseString {

    public static void main(String[] args) {
        var str = "123456121313";
        var strArr = str.split("");
        int c = 0;
        for (int i = 0, j = strArr.length - 1; i < strArr.length /2  ; i++,j--){
            c++;
            var temp = strArr[i];
            strArr[i] = strArr[j];
            strArr[j] = temp;
        }
        System.out.println(c);
        System.out.println(Arrays.toString(strArr));
    }

}
