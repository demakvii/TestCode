package com.mak;

import java.util.Arrays;

public class SwapZeroOneTwo {

    public static void main(String[] args) {
        moveZeroOne();
        System.out.println("--------------------------------------");
        moveZeroOneTwo();
    }

    static void moveZeroOne(){
        int[] arr = { 0, 1, 1, 0, 1, 1, 0, 0, 0, 1 };
        int low = 0;
        int high = arr.length - 1;
        for (int i = 0 ; i <= high;){
            if(arr[i] == 0){
                int temp = arr[i];
                arr[i] = arr[low];
                arr[low] = temp;
                low++;
            }
            i++;
        }
        System.out.println(Arrays.toString(arr));
    }

    static void moveZeroOneTwo(){
        int[] arr = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
        int[] result = { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2 };
        int low = 0;
        int high = arr.length - 1;
        int count = 0;
        for (int i = 0 ; i< arr.length && i <= high;){
            count++;
            System.out.println(i + ":" + arr[i] + ": " + Arrays.toString(arr));
            if(arr[i] == 0){
                int temp = arr[i];
                arr[i] = arr[low];
                arr[low] = temp;
                low++;
                i++;
            }
            else if(arr[i] == 2){
                int temp = arr[i];
                arr[i] = arr[high];
                arr[high] = temp;
                high--;
            }else {
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.equals(arr, result));
        System.out.println(count);
    }
}
