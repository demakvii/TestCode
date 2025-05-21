package com.mak;

public class BinarySearch {

    public static void main(String[] args) {
        var arr = new int[]{1,2,3,4,5,6,7,8,9};
        int pos = bSearch(arr, 9);
        System.out.println(pos);

        pos = bSearch(arr,11);
        System.out.println(pos);

        pos = bSearch(arr, 3);
        System.out.println(pos);

        pos = bSearch(arr, -1);
        System.out.println(pos);

        pos = bSearch(arr, 5);
        System.out.println(pos);
    }

    private static int bSearch(int[] arr, int search){
        int l = 0;
        int r = arr.length - 1;
        int c = 0;
        while (l<=r){
            c++;
            int m = (l+r)/2;
            if(arr[m] == search) {
                System.out.println("Count:" + c);
                return m;
            }
            else if (arr[m] < search){
                l = m + 1;
            }
            else {
                r = m - 1;
            }
        }
        System.out.println("Count:" + c);
        return -1;
    }
}
