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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if(root == null) {
            return result;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                
                if(i == size - 1) {
                    result.add(node.val);
                }
                
                if(node.left != null) {
                    q.offer(node.left);
                }
                
                if(node.right != null) {
                    q.offer(node.right);
                }
                
            }
        }
        return result;
    }
}
