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

 //BFS
class Solution {
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            boolean foundX = false;
            boolean foundY = false;

            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();

                if(node.val == x) foundX = true;
                if(node.val == y) foundY = true;

                if(node.left!=null && node.right!=null){
                    if((node.left.val == x && node.right.val ==y) || (node.left.val == y && node.right.val == x)) return false;
                }
                if(node.left!=null)queue.offer(node.left);
                if(node.right!=null)queue.offer(node.right);
            }

            if(foundX && foundY) return true;
        }
        return false;
    }
}


/* DFS
class Solution {
    TreeNode xParent = null;
    TreeNode yParent = null;
    int xLevel = -1;
    int yLevel = -1;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null, 0, x, y);
        return xLevel == yLevel && xParent != yParent;
    }
    public void dfs(TreeNode root, TreeNode parent, int level, int x, int y){
        if(root == null) return;
        if(root.val == x){
            xParent = parent;
            xLevel = level;
        }
        if(root.val == y){
            yParent = parent;
            yLevel = level;
        }
        dfs(root.left, root, level+1, x, y);
        dfs(root.right, root, level+1, x, y);
    }
}*/