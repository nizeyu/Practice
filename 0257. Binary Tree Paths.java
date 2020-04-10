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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        
        dfs(root, String.valueOf(root.val), results);
        
        return results;
    }
    
    private void dfs(TreeNode root, String path, List<String> results) {
        if (root.left == null && root.right == null) {
            results.add(path);
        } else {
            if (root.left != null) {
                dfs(root.left, path + "->" + root.left.val, results);
            }
            
            if (root.right != null) {
                dfs(root.right, path + "->" + root.right.val, results);
            }
        }
    }
}
