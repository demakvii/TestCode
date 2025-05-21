package com.mak;

import java.util.ArrayList;
import java.util.List;

public class StackImpl {

    public static void main(String[] args) {
        var stack = new CStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack);
        while (stack.hasNext()) {
            stack.pop();
            System.out.println(stack);
        }
    }
    //LIFO  1,2,3,4 -> 1,2,3 -> 1,2 -> 1 -> null
    static class CStack<T> {

        private final List<T> data;

        public CStack(){
            data = new ArrayList<>();
        }

        public void push(T t){
            data.add(t);
        }

        public T pop(){
            if (data.isEmpty()) {
                return null;
            }
            return data.remove(data.size() - 1);
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
