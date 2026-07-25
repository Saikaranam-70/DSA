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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || n<=0) return head;
        ListNode reversed = reverse(head);
        ListNode temp = reversed;
        if(n==1){
            reversed = reversed.next;
        }else{
            int cnt = 1;
            while(temp !=null && cnt < n-1){
                temp = temp.next;
                cnt++;
            }
            if(temp!=null && temp.next!=null){
                temp.next = temp.next.next;
            }
        }
        
        
        return reverse(reversed);
    }
    public static ListNode reverse(ListNode list){
        ListNode curr = list;
        ListNode prev = null;
        while(curr !=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}