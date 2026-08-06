/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k==0){
            return head;
        }

        ListNode curr = head;
        int len = 1;

        while(curr.next!=null){
            len++;
            curr = curr.next;
        }

        k = k%len;
        if(k == 0) return head;

        curr.next = head;

        ListNode newCurr = head;

        for(int i = 0; i<len-k-1;i++){
            newCurr = newCurr.next;
        }

        ListNode newHead= newCurr.next;
        newCurr.next = null;
        return newHead;
    }
}