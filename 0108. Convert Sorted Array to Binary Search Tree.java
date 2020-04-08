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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        
        TreeNode root = sortedArrayToBST(0, nums.length - 1, nums);
        
        return root;
    }
    
    private TreeNode sortedArrayToBST(int l, int r, int[] nums) {
        if (l > r) {
            return null;
        }
        
        int mid = l + (r - l) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        
        node.left = sortedArrayToBST(l, mid - 1, nums);
        node.right = sortedArrayToBST(mid + 1, r, nums);
        
        return node;
    }
}
