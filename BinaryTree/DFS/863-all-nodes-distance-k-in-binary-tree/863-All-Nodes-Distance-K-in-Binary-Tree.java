/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<TreeNode, TreeNode> map = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        buildParent(root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        queue.offer(target);
        visited.add(target);
        int distance = 0;

        while(!queue.isEmpty()){
            if(distance == k) break;

            int size = queue.size();
            for(int i = 0;i<size;i++){
                TreeNode curr = queue.poll();

                if(curr.left!=null && visited.add(curr.left)) queue.offer(curr.left);
                if(curr.right!=null && visited.add(curr.right)) queue.offer(curr.right);
                if(map.get(curr)!=null && visited.add(map.get(curr))) queue.offer(map.get(curr));
            }
            distance++;
        }
        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            ans.add(queue.poll().val);
        }
        return ans;
    }
    public void buildParent(TreeNode child, TreeNode parent){
        if(child == null) return;
        map.put(child, parent);
        buildParent(child.left, child);
        buildParent(child.right, child);
    }
}