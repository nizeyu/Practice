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
    
    private int min = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        getDepth(1, root);
        
        return min;
    }
    
    private void getDepth(int depth, TreeNode root) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null) {
            min = Math.min(min, depth);
        }
        
        getDepth(depth + 1, root.left);
        getDepth(depth + 1, root.right);
    }
}
