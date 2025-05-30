package com.mak;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class QueueWithStack {
    public static void main(String[] args) {
        var list = List.of(1, 2, 3, 4, 5, 6);

        CQueue<Integer> queue = new CQueue<>();
        list.forEach(queue::add);
        queue.add(7);

        while (!queue.isEmpty()){
            System.out.print(queue.poll() + ">>");
        }
    }

    static class CQueue<T> {
        private final Stack<T> data = new Stack<>();
        public void add(T element) {
            List<T> tempList = new ArrayList<>();
            while (!isEmpty()){
                tempList.add(this.data.pop());
            }
            data.add(element);
            for(int i = tempList.size() - 1; i >= 0; i--) {
                data.add(tempList.get(i));
            }
        }

        public T poll() {
            return this.data.pop();
        }

        public boolean isEmpty(){
            return data.isEmpty();
        }

    }
}
