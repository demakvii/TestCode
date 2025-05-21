package com.mak;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        var arr = new int[] {100, 99, 98, 7 , 2 ,1};

        System.out.println("Before sorting: " + Arrays.toString(arr));

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("Before sorting: " + Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int start, int end){
        if(start < end) {
            int mid =  start + (end - start)/2;

            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            System.out.println("Checking for start " + start + " end " + end);
            merge(arr, start, mid, end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        var temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int idx = 0;
        while (i <= mid && j <= end){
            if(arr[i] <= arr[j]){
                temp[idx++] = arr[i];
                i++;
            } else {
                temp[idx++] = arr[j];
                j++;
            }
        }

        while (i <= mid){
            temp[idx++] = arr[i];
            i++;
        }

        while (j <= end){
            temp[idx++] = arr[j];
            j++;
        }

        for(int k = 0; k < temp.length; k++){
            arr[start + k] = temp[k];
        }
        System.out.println("Iteration:" + Arrays.toString(arr));
    }
}
