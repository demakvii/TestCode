package com.mak.ll;

import com.mak.model.ListNode;

public class DetectCycle {

    public static void main(String[] args) {
        var list1N4 = new ListNode(4);
        var list1N3 = new ListNode(3, list1N4);
        var list1N2 = new ListNode(2, list1N3);
        var head = new ListNode(1, list1N2);

        list1N4.next = list1N2;  //cycle

        //1->2->3->4->1
        var cyclePosition = detectCyclePosition(head);
        if (cyclePosition != null)
            System.out.println("Cycle detected: " + cyclePosition.val);
    }

    private static boolean detectCycle(ListNode head){
        var fastHead = head;
        var slowHead = head;

        while (fastHead != null && fastHead.next != null){
            fastHead = fastHead.next.next;
            slowHead = slowHead.next;
            if (fastHead == slowHead)
                return true;
        }
        return false;

    }

    private static ListNode detectCyclePosition(ListNode head){
        var fastHead = head;
        var slowHead = head;

        while (fastHead != null && fastHead.next != null){
            fastHead = fastHead.next.next;
            slowHead = slowHead.next;
            if (fastHead == slowHead)
                break;
        }
        if (fastHead == null || fastHead.next == null)
            return null;

        while (head.val != slowHead.val){
            head = head.next;
            slowHead = slowHead.next;
        }
        return head;
    }
}
