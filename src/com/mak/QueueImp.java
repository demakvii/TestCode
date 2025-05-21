package com.mak;

import java.util.ArrayList;
import java.util.List;

public class QueueImp {

    public static void main(String[] args) {

        var queue = new CQueue<Integer>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);

        System.out.println(queue);
        while (queue.hasNext()) {
            queue.pop();
            System.out.println(queue);
        }
    }

    //1,2,3,4 -> 2,3,4 -> 3,4 -> 4
    //FIFO

    static class CQueue<T> {
        private final List<T> data;

        public CQueue(){
            data = new ArrayList<>();
        }

        public void push(T t){
            data.add(t);
        }

        public T pop(){
            if (data.isEmpty()) {
                return null;
            }
            return data.remove(0);
        }

        public boolean hasNext(){
            return !data.isEmpty();
        }

        @Override
        public String toString() {
            return "CStack{" +
                    "data=" + data +
                    '}';
        }
    }
}
