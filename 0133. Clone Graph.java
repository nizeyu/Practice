/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        
        List<Node> nodes = getNodes(node);
        
        Map<Node, Node> map = new HashMap<>();
        for (Node n : nodes) {
            map.put(n, new Node(n.val));
        }
        
        for (Node n : nodes) {
            for (Node neighbor : n.neighbors) {
                map.get(n).neighbors.add(map.get(neighbor));
            }
        }
        
        return map.get(node);
    }
    
    private List<Node> getNodes(Node node) {
        List<Node> nodes = new ArrayList();
        if (node == null) {
            return nodes;
        }
        
        Queue<Node> q = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        q.offer(node);
        visited.add(node);
        
        while (!q.isEmpty()) {
            Node n = q.remove();
            nodes.add(n);
            if (n.neighbors == null) {
                continue;
            }
            
            for (Node neighbor : n.neighbors) {
                if (visited.contains(neighbor)) {
                    continue;
                }
                
                q.offer(neighbor);
                visited.add(neighbor);
            }
        }
        
        return nodes;
    }
}
