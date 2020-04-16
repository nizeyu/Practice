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
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        
        if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        }
        
        if (root.val > R) {
            return rangeSumBST(root.left, L, R);
        }
        
        int left = rangeSumBST(root.left, L, R);
        int right = rangeSumBST(root.right, L, R);
        
        return root.val + left + right;
    }
}
