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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> results = new ArrayList<>();
        
        Map<TreeNode, TreeNode> map = new HashMap<>();
        map.put(root, null);
        preOrder(root, map);
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        
        Set<TreeNode> set = new HashSet<>();
        set.add(target);
        
        while (!q.isEmpty()) {
            int size = q.size();
            
            if (K == 0) {
                for (TreeNode n : q) {
                    if (n != null) {
                        results.add(n.val);
                    }
                }
                return results;
            }
            
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (node.left != null && !set.contains(node.left)) {
                    q.offer(node.left);
                    set.add(node.left);
                }

                if (node.right != null && !set.contains(node.right)) {
                    q.offer(node.right);
                    set.add(node.right);
                }

                TreeNode par = map.get(node);
                if (par != null && !set.contains(par)) {
                    q.offer(par);
                    set.add(par);
                }
            }  
            K--;
        }
        
        return results;
    }
    
    private void preOrder(TreeNode root, Map<TreeNode, TreeNode> map) {
        if (root == null) {
            return;
        }
        
        if (root.left != null) {
            map.put(root.left, root);
        }
        
        if (root.right != null) {
            map.put(root.right, root);
        }
        
        preOrder(root.left, map);
        preOrder(root.right, map);
        
        return;
    }
}
