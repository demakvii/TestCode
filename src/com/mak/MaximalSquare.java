package com.mak;

public class MaximalSquare {

    public static void main(String[] args) {
        String [][] arr = {
                {"1","0","1","0","0"},
                {"1","0","1","1","1"},
                {"1","1","1","1","1"},
                {"1","0","0","1","0"}};
        Integer [][] cache = new Integer[arr.length][arr[0].length];

        calculate(arr, cache, 0, 0);

        int max = -1;
        for(int i = 0; i< arr.length; i++){
            for(int j = 0; j< arr[i].length; j++){
                if(cache[i][j] > max)
                    max = cache[i][j];
            }
        }
        System.out.println(max * max);
    }
    private static int calculate(String[][] arr, Integer[][] cache, int r, int c){
        if(r >= arr.length || c >= arr[0].length){
            return 0;
        }

        if(cache[r][c] == null){
            int right = calculate(arr, cache, r, c + 1);
            int down = calculate(arr, cache, r + 1, c);
            int diagonal = calculate(arr, cache, r + 1, c + 1);
            cache[r][c] = 0;
            if (arr[r][c].equals("1")) {
                cache[r][c] = 1 + Math.min(Math.min(right, down), diagonal);
            }
        }

        return cache[r][c];
    }
}
