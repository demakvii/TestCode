package com.mak.ll;

import com.mak.model.ListNode;

public class RotateLL {
    public static void main(String[] args) {
        var list1N5 = new ListNode(5);
        var list1N4 = new ListNode(4, list1N5);
        var list1N3 = new ListNode(3, list1N4);
        var list1N2 = new ListNode(2, list1N3);
        var head = new ListNode(1, list1N2);

        int k = 1;

        var temp = head;
        int n = 0;
        while (temp.next != null){
            temp = temp.next;
            n++;
        }
        n++;
        temp.next = head;

        k = k % n;
        if(k == 0){
            temp.next = null;
        } else {
            for (int i = 0; i < (n - k); i++) {
                temp = temp.next;
            }
            head = temp.next;
            temp.next = null;
        }
        System.out.println(head);


    }
}
