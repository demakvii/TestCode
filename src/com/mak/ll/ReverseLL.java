package com.mak.ll;

import com.mak.model.ListNode;

public class ReverseLL {

    //1,2,3,4,5
    //5,4,3,2,1

    public static void main(String[] args) {
        var n5 = new ListNode(5);
        var n4 = new ListNode(4, n5);
        var n3 = new ListNode(3, n4);
        var n2 = new ListNode(2, n3);
        var head = new ListNode(1, n2);

        System.out.println(head);
        head = reverseRecursive(head);
        System.out.println(head);
        head = reverseRecursive(head);
        reverseIterative(head);
    }
    //1 ,2 , 3
    private static void reverseIterative(ListNode head){
        ListNode previousNode = head;
        ListNode currentNode = head.next;

        while (currentNode != null){
            ListNode nextNode = currentNode.next;
            currentNode.next = previousNode;

            previousNode = currentNode;
            currentNode = nextNode;
        }
        head.next = null;
        head = previousNode;

        System.out.println(head);
    }

    private static ListNode reverseRecursive(ListNode head){
        if(head == null || head.next == null)
            return head;

        var newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

}
