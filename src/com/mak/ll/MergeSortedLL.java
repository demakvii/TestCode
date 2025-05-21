package com.mak.ll;

import com.mak.model.ListNode;

public class MergeSortedLL {
    public static void main(String[] args) {
        var list1N3 = new ListNode(4);
        var list1N2 = new ListNode(2, list1N3);
        var head1 = new ListNode(1, list1N2);

        var list2N3 = new ListNode(4);
        var list2N2 = new ListNode(3, list2N3);
        var head2 = new ListNode(1, list2N2);

        var result = new ListNode(0);
        var head3 = result;

        while (head1 != null || head2 != null) {
            if(head1 != null && head2 != null) {
                if(head1.val < head2.val){
                    head3.next = new ListNode(head1.val);
                    head1 = head1.next;
                }else if(head2.val < head1.val){
                    head3.next = new ListNode(head2.val);
                    head2 = head2.next;
                }else {
                    head3.next = new ListNode(head2.val);
                    head3 = head3.next;
                    head3.next = new ListNode(head2.val);
                    head1 = head1.next;
                    head2 = head2.next;
                }
            }else if(head1 != null) {
                head3.next = new ListNode(head1.val);
                head1 = head1.next;
            }else {
                head3.next = new ListNode(head2.val);
                head2 = head2.next;
            }
            head3 = head3.next;
        }
        System.out.println(result.next);
    }
}
