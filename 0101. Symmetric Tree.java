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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        return isSymmetricTree(root.left, root.right);
    }
    
    private boolean isSymmetricTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == null && q == null;
        }
        
        if (p.val != q.val) {
            return false;
        }
        
        return isSymmetricTree(p.left, q.right) && isSymmetricTree(p.right, q.left);
    }
}
