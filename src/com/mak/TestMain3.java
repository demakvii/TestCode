package com.mak;

public class TestMain3 {
    public static void main(String[] args) {
        try {
            divide(1,0);
        }catch (Exception e){
            System.out.println("Exception");
        }finally {
            System.out.println("Finally main");
        }
    }

    private static void divide(int a, int b){
        try{
            var c = a/b;
            System.out.println(c);
        }finally {
            System.out.println("Finally");
        }
    }
}
