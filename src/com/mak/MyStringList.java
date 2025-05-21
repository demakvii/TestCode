package com.mak;

import java.util.List;

public class MyStringList {

    private final List<String> list;

    public MyStringList(List<String> list){
        this.list = list;
    }

    public void doSomething(){
        list.forEach(System.out::println);
    }

}
