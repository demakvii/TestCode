package com.mak;

public class FindPeakNumber {

    // 1 3 7 6 6 6 6 4 3 2 1
    // 1 3 6 6 6 6 7 4 3 2 1

    public static void main(String[] args) {
        var arr = new int[] {1,3, 6, 6, 6, 6, 7, 4, 3, 2, 1};
        //var arr = new int[] {5,4,3,2,1};
        std(arr);
    }

    private static void std(int[] arr){
        int max = -1;
        int count = 0;
        for (int j : arr) {
            count++;
            if (j >= max) {
                max = j;
            }else break;
        }
        System.out.println(max + " iterated :" + count);
    }
    //1 3 7 5 4 2 -- 22, 50 , 58 ,61
    private static int bsApproach(int[] arr) {
        // 1 3 6 6 6 6 7 4 3 2 1
        if (arr.length == 0) {
            return -1;
        }
        int left = arr[0];
        int right = arr[arr.length - 1];
        if (left == right)
            return left;
        else


        return -1;
    }
}
