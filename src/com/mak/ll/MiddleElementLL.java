package com.mak.ll;

import com.mak.model.ListNode;

public class MiddleElementLL {

    public static void main(String[] args) {
        var n7 = new ListNode(7);
        var n6 = new ListNode(6, n7);
        var n5 = new ListNode(5, n6);
        var n4 = new ListNode(4, n5);
        var n3 = new ListNode(3, n4);
        var n2 = new ListNode(2, n3);
        var head = new ListNode(1, n2);

        var slowPtr = head;
        var fastPtr = head;
        while (fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        System.out.println(slowPtr.val);
    }

}
