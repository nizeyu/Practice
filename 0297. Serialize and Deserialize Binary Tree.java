/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        sb.append(root.val);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            
            if (node.left != null) {
                queue.offer(node.left);
                sb.append(',');
                sb.append(node.left.val);
            } else {
                sb.append(",null");
            }
            
            if (node.right != null) {
                queue.offer(node.right);
                sb.append(',');
                sb.append(node.right.val);
            } else {
                sb.append(",null");
            }
        }
        
        String s = sb.toString();
        int end = s.length() - 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (Character.isDigit(s.charAt(i))) {
                end = i;
                break;
            }
        }
        s = s.substring(0, end + 1);
        
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        
        String[] vals = data.split(",");
        
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        
        while (!queue.isEmpty() && i < vals.length) {
            TreeNode node = queue.poll();
            
            if (vals[i].equals("null")) {
                node.left = null;
                i++;
            } else {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.offer(node.left);
                i++;
            }
                
            if (i < vals.length) {
                if (vals[i].equals("null")) {
                    node.right = null;
                    i++;
                } else {
                    node.right = new TreeNode(Integer.parseInt(vals[i]));
                    queue.offer(node.right);
                    i++;
                }
            }
        }  
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
