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
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        ListNode firstDummy = new ListNode(0);
        ListNode secondDummy = new ListNode(0);

        ListNode first = firstDummy;
        ListNode second = secondDummy;

        ListNode curr = head;
        while(curr!=null){
            if(curr.val < x){
                first.next = curr;
                first = first.next;
            }else{
                second.next = curr;
                second = second.next;
            }
            curr = curr.next;
        }

        second.next = null;

        first.next = secondDummy.next;
        return firstDummy.next;
    }
}