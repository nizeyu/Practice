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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

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
    private int max;
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        max = 0;
        
        getDepth(1, root);
        
        return max;
    }
    
    private void getDepth(int depth, TreeNode root) {
        if (root == null) {
            return;
        }
        
        max = Math.max(max, depth);
        
        getDepth(depth + 1, root.left);
        getDepth(depth + 1, root.right);
    }
}
