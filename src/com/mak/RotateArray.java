package com.mak;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        shiftArrayTempArr(args, 1);
        //shiftArrayRecursive(args, 3);
        //shiftByAlgorithm(args, 1);
    }

    private static void shiftArrayTempArr(String[] args, int move){
        String[] shiftArgs = new String[args.length];
        for(int i = 0; i < args.length; i++){
            int moveTo = (i + move) % args.length;
            shiftArgs[moveTo] = args[i];
        }
        System.out.println(Arrays.toString(shiftArgs));
    }

    private static void shiftArrayRecursive(String[] args, int move){
        if (move == 0){
            System.out.println("Final: " + Arrays.toString(args));
            return;
        }
        String temp = null; //2
        for(int i = 0; i < args.length; i++){
            var nextTemp = args[i];
            if(temp != null)
                args[i] = temp;
            temp = nextTemp;
        }
        args[0] = temp;
        System.out.println(move + " iteration: " + Arrays.toString(args));
        shiftArrayRecursive(args, --move);
    }

    /// 1,2,3,4,5,6
    /// 1,2,3,6,5,4  -- reverse last k numbers
    /// 3,2,1,6,5,4  -- reverse first k - n numbers
    /// 4,5,6,1,2,3  -- reverse whole numbers

    private static void shiftByAlgorithm(String[] args, int move){
        System.out.println("Input:" + Arrays.toString(args));
        int n = args.length;
        int k = move % n;
        for(int i = n - k, j = n - 1; i < j; i++, j--){
             String temp = args[i];
             args[i] = args[j];
             args[j] = temp;
        }
        System.out.println("Step 1:" + Arrays.toString(args));
        for(int i = 0, j = n - k - 1; i < j; i++, j--){
            String temp = args[i];
            args[i] = args[j];
            args[j] = temp;
        }
        System.out.println("Step 2:" + Arrays.toString(args));
        for(int i = 0, j = n - 1; i < j; i++, j--){
            String temp = args[i];
            args[i] = args[j];
            args[j] = temp;
        }
        System.out.println("Step 3:" + Arrays.toString(args));
    }

    private static void nextMove(int size, int move, int idx){
        int k = move % size;
        System.out.println(k);
    }

}
