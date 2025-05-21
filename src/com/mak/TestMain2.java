package com.mak;

import java.util.Objects;

public class TestMain2 {
    public static void main(String[] args) {
        var str1 = "bank";
        var str2 = "kabn";
        if(str1.chars().sum() != str2.chars().sum()){
            System.out.println("String is not equal in any sense");
            return;
        }
        var str1Arr = str1.split("");
        var str2Arr = str2.split("");
        int count = 0;
        for (int i = 0; i < str1.length(); i++){
            if(!Objects.equals(str1Arr[i], str2Arr[i]))
                count++;
        }
        if (count == 2)
            System.out.println("Success");
        else
            System.out.println("Fail");
    }

}
