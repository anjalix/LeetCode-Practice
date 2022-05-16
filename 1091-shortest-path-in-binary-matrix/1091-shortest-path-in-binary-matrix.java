class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1)
            return -1;
        int cnt = 0,x,y;
        // to move in all 8 direction
        int[][] movement = new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        boolean [][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        visited[0][0] = true;
        
        int[] pop;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int p = 0;p<size;p++) {
                pop = queue.remove();
                if(pop[0] == n-1 && pop[1] == n-1)
                    return cnt+1;
            for(int i = 0;i<8;i++)
                {
                    x = pop[0] + movement[i][0];
                    y = pop[1] + movement[i][1];
                
                    if(x>=0 && x<n && y>=0 && y<n && grid[x][y]==0 && !visited[x][y])
                    {
                        visited[x][y] = true;
                        queue.add(new int[]{x,y});
                    }
                }
            }
            cnt++;
        }
        return -1;
    }
}