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
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxSum(root);
        return maxSum;
    }
    public int maxSum(TreeNode root){
        if(root == null) return 0;

        int left = Math.max(maxSum(root.left), 0);
        int right = Math.max(maxSum(root.right), 0);

        int preSum = root.val + left + right;

        maxSum = Math.max(preSum, maxSum);

        return root.val + Math.max(left, right);
    }
}