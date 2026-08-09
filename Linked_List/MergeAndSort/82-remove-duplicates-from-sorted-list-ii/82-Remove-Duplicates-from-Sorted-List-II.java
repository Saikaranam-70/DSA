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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        ListNode curr = head;

        while(curr!=null){
            if(curr.next ==null || curr.val!=curr.next.val){
                tail.next = curr;
                tail = tail.next;
            }

            while(curr.next!=null && curr.val == curr.next.val){
                curr = curr.next;
            }
            curr = curr.next;
        }
        tail.next = null;
        return dummy.next;
    }
}