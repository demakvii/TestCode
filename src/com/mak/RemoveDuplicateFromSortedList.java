package com.mak;

import java.util.Arrays;

public class RemoveDuplicateFromSortedList {

    public static void main(String[] args) {
        var arr = new int[]{1,2,2,2,3,4,5,6};
        int count = 1;
        int j = 1;
        for (int i = 1; i < arr.length; i++){
            if(arr[i] == arr[i - 1]){
                count++;
            }else {
                count = 1;
            }
            if(count <= 2){
                arr[j] = arr[i];
                j++;
            }
            System.out.println(Arrays.toString(arr));
        }

        System.out.println(j);
        System.out.println(Arrays.toString(arr));
    }

}
