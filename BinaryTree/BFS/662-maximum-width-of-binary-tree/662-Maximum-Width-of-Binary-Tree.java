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
    class Pair{
        TreeNode root;
        long vertex;
        Pair(TreeNode root, long vertex){
            this.root = root;
            this.vertex = vertex;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        int maxWidth = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            long first = queue.peek().vertex;
            long last = first;
            for(int i = 0; i<size;i++){
                Pair curr = queue.poll();
                last = curr.vertex;

                if(curr.root.left!=null) queue.offer(new Pair(curr.root.left, 2*curr.vertex));
                if(curr.root.right != null) queue.offer(new Pair(curr.root.right, 2*curr.vertex+1));
            }
            maxWidth = Math.max(maxWidth, (int)(last-first+1));
        }
        return maxWidth;
    }
}