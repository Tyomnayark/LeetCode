package tasks.removenode;

import java.util.ArrayList;

public class Solution {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode currentNode = head.next;
        ListNode lastNode = head;
        ListNode prev = new ListNode();

        int counter = 1;

        while (currentNode != null) {
            counter++;
            currentNode = currentNode.next;
        }


        if (n < counter){
            int nth = counter - n;
            currentNode = lastNode.next;
            prev = currentNode.next;

            while (nth!= 1){
                lastNode = currentNode;
                currentNode = prev;
                prev = currentNode.next;
                nth--;
            }
            lastNode.next = prev;
        }else if (n == counter){
            return head.next;
        }

        return head;
    }

}
