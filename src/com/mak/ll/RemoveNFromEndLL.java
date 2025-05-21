package com.mak.ll;

import com.mak.model.ListNode;

public class RemoveNFromEndLL {

    //1, 2, 3, 4, 5
    //3 -> 5

    public static void main(String[] args) {
        var n5 = new ListNode(5);
        var n4 = new ListNode(4, n5);
        var n3 = new ListNode(3, n4);
        var n2 = new ListNode(2, n3);
        var head = new ListNode(1, n2);

        ListNode res = new ListNode(0, head);
        ListNode dummy = res;
        int n = 2;

        for (int i = 0; i < n; i++) {
            head = head.next;
        }
        while (head != null){
            head = head.next;
            dummy = dummy.next;
        }

        dummy.next = dummy.next.next;

        System.out.println(res.next);
    }
}
