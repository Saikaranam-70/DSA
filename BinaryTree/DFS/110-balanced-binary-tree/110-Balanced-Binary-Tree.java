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
    public boolean isBalanced(TreeNode root) {
      return dfs(root) != -1;
    }
    public static int dfs(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = dfs(root.left);
        if(left == -1) return -1;
        int right = dfs(root.right);
        if(right == -1) return -1;

        if(Math.abs(right-left) > 1) return -1;

        return 1+ Math.max(left, right);
    }
}



/*  BFS
class Solution {
    public boolean isBalanced(TreeNode root) {
       if(root == null) return true;
       Queue<TreeNode> q = new LinkedList<>();
       q.offer(root);

       while(!q.isEmpty()){
        TreeNode node = q.poll();

        int left = height(node.left);
        int right = height(node.right);

        if(Math.abs(right-left) > 1) return false;

        if(node.left != null) q.offer(node.left);
        if(node.right != null) q.offer(node.right);


       }
       return true;
    }

    public static int height(TreeNode root){
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int height = 0;

        while(!queue.isEmpty()){
            int size = queue.size();

            while(size > 0){
                TreeNode node = queue.poll();

                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);

                size--;
            }
            height++;
        }

        return height;
    }
} */