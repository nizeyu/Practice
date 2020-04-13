class Cell {
    int x, y;
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    
    int[] dx = new int[]{-1, 0, 1, 0};
    int[] dy = new int[]{0, -1, 0, 1};
    
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        
        Queue<Cell> queue = new LinkedList<>();
        Map<Cell, Integer> depth = new HashMap<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    Cell cell = new Cell(i, j);
                    queue.offer(cell);
                    depth.put(cell, 0);
                }
            }
        }
        
        int result = 0;
        while (!queue.isEmpty()) {
            Cell c = queue.remove();
            
            for (int k = 0; k < 4; k++) {
                int x = c.x + dx[k];
                int y = c.y + dy[k];
                
                if (!inbound(x, y, grid)) {
                    continue;
                }
                
                if (grid[x][y] != 1) {
                    continue;
                }
                
                grid[x][y] = 2;
                Cell newCell = new Cell(x, y);
                queue.offer(newCell);
                depth.put(newCell, depth.get(c) + 1);
                result = depth.get(newCell); 
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        
        return result;
    }
    
    private boolean inbound(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return false;
        }
        
        return true;
    }
}
