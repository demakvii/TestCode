package com.mak;

import java.util.Arrays;
import java.util.Comparator;

public class ShiftOneToLeft {

    public static void main(String[] args) {
        var arr = new int[] {1, 2, 3, 2, 4, 1, 1, 2, 1, 3, 1};
        System.out.println(Arrays.toString(arr));
        int j =  arr.length - 1;
        for(int i = arr.length - 1 ; i >=0; i--){
            if(arr[i] != 1){
                arr[j] = arr[i];
                j--;
            }
        }
        for(int k = 0; k <= j ; k++){
            arr[k] = 1;
        }
        System.out.println(Arrays.toString(arr));

        var list = Arrays.asList(1, 3, 2, 4, 3,1 ,2);
        list.stream().sorted(Comparator.reverseOrder()).distinct().forEach(System.out::print);
    }
}
