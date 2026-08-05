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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null) return head;

        ListNode curr = head;
        ListNode prev = null;
        for(int i = 1;i<left;i++){
            prev = curr;
            curr = curr.next;
        }

        ListNode reversed = reverse(curr, right-left+1);
        if(prev == null) return reversed;
        prev.next = reversed;
        return head; 
    }
    public ListNode reverse(ListNode head, int index){
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr!=null && index>0){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            index--;
        }
        head.next = curr;
        return prev;
    }
}