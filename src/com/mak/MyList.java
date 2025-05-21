package com.mak;

import java.util.List;

public class MyList<T> extends Thread{

    private List<T> list;

    public void setList(List<T> list) {
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }

    public void doSomething(){
        list.forEach(System.out::println);
    }

    @Override
    public void run() {
        super.run();
    }

    @Override
    public synchronized void start() {
        super.start();
    }
}
