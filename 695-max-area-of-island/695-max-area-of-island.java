class Solution {
    
    public int max = 0;
    
    public int countOne(int[][] grid, int i , int j, int cnt, int m, int n) {
        grid[i][j] = 9;
        if(i+1<m && grid[i+1][j] == 1)
            cnt = countOne(grid, i+1, j, cnt+1, m, n);
        if(j+1<n && grid[i][j+1] == 1)
            cnt = countOne(grid, i, j+1, cnt+1, m, n);
        if(i-1 >= 0 && grid[i-1][j] == 1)
            cnt = countOne(grid, i-1, j, cnt+1, m, n);
        if(j-1 >= 0 && grid[i][j-1] == 1)
            cnt = countOne(grid, i, j-1, cnt+1, m, n);        
        return cnt;
    }
    
    
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        int cnt = 0;
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(grid[i][j] == 1) {
                    cnt = countOne(grid, i,j,1,m,n);
                    max = Math.max(max, cnt);
                }
            }
        }
        return max;
    }
}