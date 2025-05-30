package com.mak;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class StackWithQueue {

    public static void main(String[] args) {
        var list = List.of(1, 2, 3, 4, 5, 6);
        CStack<Integer> stack = new CStack<>(list);
        stack.push(7);
        stack.push(8);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + ">>");
        }
        System.out.print("end");
    }

    static class CStack<T> {

        private Queue<T> data;
        private int top;

        CStack(){
            this.data = new LinkedList<>();
            this.top = -1;
        }

        CStack(List<T> list){
            this.data = new LinkedList<>(list);
            this.top = list.size() - 1;
        }

        public void push(T ele){
            data.add(ele);
            this.top++;
        }

        public T pop() {
            var tempData = new LinkedList<T>();
            while (this.top != 0){
                var ele = this.data.poll();
                this.top--;
                tempData.add(ele);
            }
            var popElement = this.data.poll();
            this.data = tempData;
            this.top = this.data.size() - 1;
            return popElement;
        }

        public boolean isEmpty() {
            return data.isEmpty();
        }

    }
}
