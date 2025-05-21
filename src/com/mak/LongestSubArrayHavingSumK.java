package com.mak;

import java.util.HashMap;

public class LongestSubArrayHavingSumK {

    public static void main(String[] args) {
        int[] arr = new int[]{10, 5, 2, 7, 1, -10};
        int k = 15;
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            int sum = 0;
            for(int j = i; j < arr.length;j++){
                sum += arr[j];
                if (sum == k){
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
        System.out.println(solution(arr, 15));
    }

    private static int solution(int[] arr, int k){
        var map = new HashMap<Integer, Integer>();
        var sum = 0;
        var count  = 0;
        for(int i = 0 ; i < arr.length; i++){
            sum += arr[i];

            if(sum == k){
                count = i + 1;
            }

            if(map.containsKey(sum - k)){
                count = Math.max(count, i + map.get(sum - k));
            }

            if(!map.containsKey(sum)){
                map.put(sum, i);
            }

        }
        return count;
    }
}
