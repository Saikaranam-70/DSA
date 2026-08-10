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
    public ListNode removeNodes(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        ListNode curr = head;
        Stack<ListNode> stack = new Stack<>();
        while(curr!=null){
            while(!stack.isEmpty() && stack.peek().val < curr.val){
                stack.pop();
            }
            stack.push(curr);
            curr = curr.next;
        }

        for(int i = 0; i< stack.size();i++){
            temp.next = stack.get(i);
            temp =temp.next;
        }
        temp.next = null;

        

        return dummy.next;
    }
}