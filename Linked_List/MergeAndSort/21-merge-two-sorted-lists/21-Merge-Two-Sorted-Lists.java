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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode first = list1;
        ListNode second = list2;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        while(first!=null && second!=null){
            if(first.val<=second.val){
                curr.next = first;
                curr = curr.next;
                first = first.next;
            }else{
                curr.next = second;
                curr = curr.next;
                second = second.next;
            }
        }

        if(first!=null){
            curr.next = first;
            curr = curr.next;
            first = first.next;
        }
        else{
            curr.next = second;
            curr = curr.next;
            second = second.next;
        }
        return dummy.next;
    }
}