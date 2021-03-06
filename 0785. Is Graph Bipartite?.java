class Solution {
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return true;
        }
        
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length == 0) {
                continue;
            }
            
            if (visited.contains(i)) {
                continue;
            }
            
            if (!bfs(i, visited, graph)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean bfs(int index, Set<Integer> visited, int[][] graph) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> groupA = new HashSet<>();
        Set<Integer> groupB = new HashSet<>();
        
        q.offer(index);
        visited.add(index);
        groupA.add(index);
        boolean isGroupA = false;
        
        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                int node = q.poll();
                
                int len = graph[node].length;
                for (int j = 0; j < len; j++) {
                    int neighbor = graph[node][j];
                    
                    if (!isGroupA) {
                        if (groupA.contains(neighbor)) {
                            return false;
                        }
                        
                        groupB.add(neighbor);
                    } else {
                        if (groupB.contains(neighbor)) {
                            return false;
                        }
                        
                        groupA.add(neighbor);
                    }
                    
                    if (visited.contains(neighbor)) {
                        continue;
                    }
                    
                    q.offer(neighbor);
                    visited.add(neighbor);
                } 
            }
            
            isGroupA = !isGroupA;
        }
        
        return true;
    }
}
