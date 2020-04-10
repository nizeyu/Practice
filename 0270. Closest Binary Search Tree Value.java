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
    double min = Double.MAX_VALUE;
    int value = Integer.MIN_VALUE;
    public int closestValue(TreeNode root, double target) {
        
        helper(root, target);
        
        return value;
    }
    
    private void helper(TreeNode root, double target) {
        if (root == null) {
            return;
        }
        
        if (Math.abs(root.val - target) < min) {
            value = root.val;
            min = Math.min(min, Math.abs(root.val - target));
        }
        
        if (root.val == target) {
            return;
        } else if(root.val > target) {
            helper(root.left, target);
        } else {
            helper(root.right, target);
        }
    }
}
