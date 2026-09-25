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

    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while(curr!=null){
            if(curr.left!=null){
                TreeNode temp = curr.right;
                curr.right = curr.left;
                curr.left = null;

                TreeNode rightNode = rightMost(curr.right);
                rightNode.right = temp;
            }
            curr = curr.right;

        }
    }
   public TreeNode rightMost(TreeNode root){
    while(root.right!=null){
        root = root.right;
    }
    return root;
   }
}



/* Brute Force
class Solution {
    List<TreeNode> list = new ArrayList<>();
    public void flatten(TreeNode root) {
        dfs(root);
        for(int i = 0;i<list.size()-1;i++){
            list.get(i).left = null;
            list.get(i).right = list.get(i+1);
        }
    }
    public void dfs(TreeNode root){
        if(root == null) return;
        list.add(root);
        dfs(root.left);
        dfs(root.right);
    }
}*/