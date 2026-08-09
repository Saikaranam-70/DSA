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
    public void reorderList(ListNode head) {
    if(head == null || head.next == null) return ;
    ListNode slow = head;
    ListNode fast = head;
    while(fast.next!=null && fast.next.next!=null){
        slow = slow.next;
        fast = fast.next.next;
    }
    ListNode mid = slow.next;
    slow.next = null;
    ListNode reversed = reverse(mid);

    merge(reversed, head);
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
    public void merge(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        ListNode prev = null;

        while(list1!=null && list2!=null ){
            ListNode next1 = list1.next;
            ListNode next2 = list2.next;

            list2.next = list1;
            list1.next = next2;

            list1 = next1;
            list2 = next2;
        }
        
    }
}