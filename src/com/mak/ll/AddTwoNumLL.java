package com.mak.ll;

import com.mak.model.ListNode;

public class AddTwoNumLL {
    public static void main(String[] args) {
        var list1N3 = new ListNode(3);
        var list1N2 = new ListNode(4, list1N3);
        var list1N1 = new ListNode(2, list1N2);

        var list2N3 = new ListNode(4);
        var list2N2 = new ListNode(6, list2N3);
        var list2N1 = new ListNode(5, list2N2);

        ListNode dummyHead = new ListNode(0);
        ListNode output = dummyHead;

        var list1 = list1N1;
        var list2 = list2N1;
        var carry = 0;
        while (list1 != null || list2 != null) {
            var list1Value = list1 == null ? 0 : list1.val;
            var list2Value = list2 == null ? 0 : list2.val;
            var number = list1Value + list2Value + carry;
            var sum = number % 10;
            carry = number / 10;

            output.next = new ListNode(sum);
            output = output.next;

            System.out.println("Sum: " + sum);
            list1 = list1 == null ? null : list1.next;
            list2 = list2 == null ? null : list2.next;
        }
        // 0 -> 7
        // 7
        // 7 -> 0
        // 0
        // 0 -> 8
        // 8
        System.out.println(dummyHead.next);
    }
}
