package com.mak;

import java.util.HashMap;

public class FindFirstNonRepeatingCharacter {

    public static void main(String[] args) {
        var str = "dacedafij";
        var map = new HashMap<Character, Integer>();
        for(int i = 0; i < str.length(); i++){
            var c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        String nonRepChar = null;
        for(int j = 0; j <  str.length(); j++){
            if(map.get(str.charAt(j)) == 1) {
                nonRepChar = String.valueOf(str.charAt(j));
                break;
            }

        }

        System.out.println("Non repeating character [" + nonRepChar + "]");
    }


}
