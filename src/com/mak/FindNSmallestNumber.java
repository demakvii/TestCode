package com.mak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class FindNSmallestNumber {

    public static void main(String[] args) {
        var arr = new int[] {10, 2, 1, 5, 3, 6, 9}; // 1,2,3,5,6,9,10
        int n = 3;
        PriorityQueue<Integer> list = new PriorityQueue<>((a, b) -> b - a);
        for (var num : arr){
            list.add(num);
            if(list.size() >= n)
                list.poll();
        }

        System.out.println();

        System.out.println(list.poll());

        var test = new ArrayList<>(Arrays.asList(10, 2, 1, 5, 3, 6, 9));
        test.sort((a, b) -> a - b);
        System.out.println(test);

        solution(arr, 2);
    }

    private static void solution(int[] arr, int k){
        int max = arr[0];
        for (int i = 0 ; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }

        int[] freq = new int[max + 1];

        for (int i = 0; i < arr.length; i++){
            freq[arr[i]]++;
        }

        int count = 0;
        int idx = -1;
        for (int i = 0 ; i< freq.length; i++){
            if (freq[i] != 0){
                count += freq[i];
                if (count >= k){
                    idx = i;
                    break;
                }
            }
        }

        System.out.println(k + " smallest number is " + idx);

        count = 0;
        idx = -1;
        for (int i = freq.length - 1 ; i >= 0; i--){
            if (freq[i] != 0){
                count += freq[i];
                if (count >= k){
                    idx = i;
                    break;
                }
            }
        }

        System.out.println(k + " largest number is " + idx);

    }
}
