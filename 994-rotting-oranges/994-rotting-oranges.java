class Solution {
    
    public int orangesRotting(int[][] grid) {
        Queue<Integer> q = new LinkedList<Integer>();
        int m = grid.length;
        int n = grid[0].length;
        int cnt = 0;
        for(int i = 0; i<m; i++) {
            for(int j = 0;j<n; j++) {
                if(grid[i][j] == 2) {
                    q.add(i);
                    q.add(j);
                }
                if(grid[i][j]!=0)
                    cnt++;
            }
        }
        q.add(-99);
        q.add(-99);
        int days = 0;
        int x; int y;
        while(!q.isEmpty() && cnt!=0) {
            x = q.remove();
            y = q.remove();
            if(x == -99) {
                if(q.isEmpty())
                    break;                
                days++;
                q.add(-99);
                q.add(-99);
                continue;
            }
            cnt--;            
            if(x+1 < m && grid[x+1][y] == 1) {
                q.add(x+1);
                q.add(y);
                grid[x+1][y] = 2;
            }
            if(y+1 < n && grid[x][y+1] == 1) {
                q.add(x);
                q.add(y+1);
                grid[x][y+1] = 2;
            }
            if(x-1 >= 0 && grid[x-1][y] == 1) {
                q.add(x-1);
                q.add(y);
                grid[x-1][y] = 2;
            }
            if(y-1 >= 0 && grid[x][y-1] == 1) {
                q.add(x);
                q.add(y-1); 
                grid[x][y-1] = 2;
            }
        }
        
        if(cnt!=0)
            return -1;
        else return days;
    }
}