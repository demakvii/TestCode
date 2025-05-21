package com.mak;

import java.util.List;

public class TestMain4 {
    public static void main(String[] args) {
        var intList = new MyList<Integer>();
        intList.setList(List.of(1));
        var charList = new MyList<Character>();
        int a = 1;
        test(a, intList);
        System.out.println(a);
        System.out.println(intList.getList());

        var b = new Integer[] {null, 0, 1};
    }

    static void test(int a, MyList<Integer> list){
        a++;
        list = new MyList<>();
    }
}
