package com.mak;

public class ShiftString {

    public static void main(String[] args) {
        var str = "mayur";
        var ch = 'a';
        int move = 2;
        int moveIdx = (str.indexOf("a") + move) % (str.length() - 1);


        var strChars = str.toCharArray();
        for(int i = 0; i < strChars.length; i++){
            if(strChars[i] == ch){
                System.out.println(moveIdx);
                if (moveIdx - i >= 0)
                    System.arraycopy(strChars, i + 1, strChars, i, moveIdx - i);
                strChars[moveIdx] = ch;
            }
        }
        System.out.println(strChars);
    }

}
