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
    public int pairSum(ListNode head) {
        if(head.next!=null && head.next.next == null) return head.val+head.next.val;

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reversed = reverse(slow.next);

        int maxSum = 0;
        ListNode first = head;
        ListNode second = reversed;
        while(second != null){
            maxSum = Math.max(maxSum, first.val + second.val);

            first = first.next;
            second = second.next;
        }
        return maxSum;
    }
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;

        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        return prev;
    }
}