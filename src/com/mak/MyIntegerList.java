package com.mak;

import java.util.List;

public class MyIntegerList {

    private final List<Integer> list;

    public MyIntegerList(List<Integer> list){
        this.list = list;
    }

    public void doSomething(){
        list.forEach(System.out::println);
    }

}
