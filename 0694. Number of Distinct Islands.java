class Point{
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int islands = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    bfs(i, j, grid);
                }
            }            
        }
        
        return islands;
    }
    
    private void bfs(int i, int j, char[][] grid) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(i, j));
        
        while (!q.isEmpty()) {
            Point c = q.poll();
            
            for (int k = 0; k < 4; k++) {
                int x = c.x + dx[k];
                int y = c.y + dy[k];
                
                if (!inBound(x, y, grid)) {
                    continue;
                }
                
                if (grid[x][y] == '0') {
                    continue;
                }
                
                grid[x][y] = '0';
                q.offer(new Point(x, y));
            }
        }
    }
    
    private boolean inBound(int i, int j, char[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return false;
        }
        
        return true;
    }
}
