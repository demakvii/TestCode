package com.mak;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheWithLHM extends LinkedHashMap<Integer, Integer>{

    private final int capacity;

    public LRUCacheWithLHM(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
       return super.getOrDefault(key, -1);
    }

    public void print(){
        System.out.println(this);
    }

    public void put(int key, int value) {
       super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) throws InterruptedException {
        var lruCache = new LRUCacheWithLHM(2);
        lruCache.print();
        lruCache.put(1,1);
        lruCache.print();
        Thread.sleep(500L);
        lruCache.put(1,1);
        lruCache.print();
        lruCache.put(2,1);
        lruCache.print();
        Thread.sleep(500L);
        lruCache.put(10,1);
        lruCache.print();
        lruCache.put(1,1);
        lruCache.print();
        Thread.sleep(500L);
        lruCache.print();
        lruCache.get(10);
        lruCache.print();
        lruCache.get(1);
        lruCache.print();

    }

}
