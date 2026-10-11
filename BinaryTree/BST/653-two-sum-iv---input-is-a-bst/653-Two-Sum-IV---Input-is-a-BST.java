/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 
class Solution {

    public boolean findTarget(TreeNode root, int k) {
        BSTIterator left = new BSTIterator(root, true);
        BSTIterator right = new BSTIterator(root, false);

        int i = left.next();
        int j = right.next();

        while(i<j){
            int sum = i + j;

            if(sum == k){
                return true;
            }else if(sum<k){
                i = left.next();
            }else{
                j = right.next();
            }
        }
        return false;
    }
}

class BSTIterator{
    Stack<TreeNode> stack = new Stack<>();
    boolean forward;

    public BSTIterator(TreeNode root, boolean forward){
        this.forward = forward;
        pushAll(root);
    }

    public void pushAll(TreeNode node){
        while(node!=null){
            stack.push(node);
            if(forward) node = node.left;
            else node = node.right;
        }
    }

    public int next(){
        TreeNode top = stack.pop();

        if(forward){
            pushAll(top.right);
        }else{
            pushAll(top.left);
        }
        return top.val;
    }

    public boolean hasNext(){
        return !stack.isEmpty();
    }
}