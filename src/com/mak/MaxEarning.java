package com.mak;

import java.util.Arrays;
import java.util.Comparator;

public class MaxEarning {

    public static void main(String[] args) {
        int[][] rides = {
                {2, 5, 4},   // Ride A
                {1, 6, 1},   // Ride B
                {6, 8, 2},   // Ride C
                {7, 9, 3}    // Ride D
        };

        rides = new int[][]{{1,6,1},{3,10,2},{10,12,3},{11,12,2},{12,15,2},{13,18,1}};

        int[] calculate = new int[rides.length + 1];
        int[] endPoints = new int[rides.length + 1];


        for(int i = 1; i <= rides.length; i++){
            endPoints[i] = rides[i - 1][1];
        }

        //Sort by end points
        Arrays.sort(rides, Comparator.comparingInt(o -> o[1]));

        System.out.println(Arrays.deepToString(rides));

        System.out.println(Arrays.toString(endPoints));

        for(int i = 1; i <= rides.length; i++){
            int startPoint = rides[i - 1][0];
            int endPoint = rides[i - 1][1];
            int tip = rides[i - 1][2];
            //1) Calculate ride price
            int price = endPoint - startPoint + tip;
            //2) Check if any previous ride end with startPoint
            // Since it's in asc order using bs to find closed number to startPoint
            int lastTripPoint = bs(endPoints, startPoint);
            //3) If found then add last end price with current price
            //4) Check if max of current price and previous price
            calculate[i] = Math.max(calculate[lastTripPoint] + price, calculate[i - 1]);
        }

        System.out.println(Arrays.toString(calculate));
        System.out.println("Best profit ride price: " + calculate[rides.length]);
    }

    private static int bs(int[] endPoints, int startPoint){
        int left = 0;
        int right = endPoints.length - 1;
        int lastPointIdx = 0;
        while (left <= right){
            int mid = left + (right - left)/2;
            if(endPoints[mid] <= startPoint) {
                lastPointIdx = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return lastPointIdx;
    }

}
