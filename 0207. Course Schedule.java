class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return true;
        }
        
        if ( prerequisites == null ||  prerequisites.length == 0 ||  prerequisites[0].length == 0) {
            return true;
        }
        
        List[] neighbors = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            neighbors[i] = new ArrayList<>();
        }
        
        int[] indegrees = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            indegrees[prerequisites[i][0]]++;
            neighbors[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        int n = 0;
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                q.offer(i);
                n++;
            }
        }
        
        while (!q.isEmpty()) {
            int course = q.poll();
            
            for (int i = 0; i < neighbors[course].size(); i++) {
                int e = (int)neighbors[course].get(i);
                indegrees[e]--;
                
                if (indegrees[e] == 0) {
                    q.offer(e);
                    n++;
                }
            }
        }
        
        return n == numCourses;
    }
}
