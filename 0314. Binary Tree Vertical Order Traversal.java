/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Position {
    TreeNode node;
    int column;
    public Position(TreeNode node, int column) {
        this.node = node;
        this.column = column;
    }
}

class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        TreeMap<Integer, List<Integer>> tmap = new TreeMap<>();
        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(root, 0));
        
        while (!q.isEmpty()) {
            Position p = q.poll();
            
            List<Integer> list = tmap.get(p.column);
            if (list == null) {
                list = new ArrayList<>();
                tmap.put(p.column, list);
            }
            list.add(p.node.val);
            if (p.node.left != null) {
                q.offer(new Position(p.node.left, p.column - 1));
            }
                        
            if (p.node.right != null) {
                q.offer(new Position(p.node.right, p.column + 1));
            }
        }
        
        for(Integer key : tmap.keySet()) {
            List<Integer> list = tmap.get(key);
            if (list != null) {
                result.add(list);
            }
        }
        
        return result;
    }
}
