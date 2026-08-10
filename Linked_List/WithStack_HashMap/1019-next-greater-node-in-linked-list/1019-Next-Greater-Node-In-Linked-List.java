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
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();

        while(head!=null){
            list.add(head.val);
            head = head.next;
        }

        int n = list.size();
        int ans[] = new int[n];

        Stack<Integer> stack = new Stack<>();
        for(int i = n-1; i>=0;i--){
            while(!stack.isEmpty() && stack.peek() <= list.get(i)) stack.pop();

            if(!stack.isEmpty()){
                ans[i] = stack.peek();
            }
            stack.push(list.get(i));
        }
        return ans;
    }
}