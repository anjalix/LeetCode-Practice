class Solution {
    int dir[][] = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public void dfs(int[][] heights, int i, int j , int last, boolean[][] ocean) {
        if(i < 0 || j < 0 || i >= heights.length || j >= heights[0].length 
           || ocean[i][j] || heights[i][j] < last)
            return;
        ocean[i][j] = true;
        for(int[] d : dir)
            dfs(heights , i + d[0] , j+d[1] , heights[i][j], ocean);
    }
    
    
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int m = heights.length;
        int n = heights[0].length;
        
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        for(int j = 0;j<n; j++){
            dfs(heights, 0, j ,Integer.MIN_VALUE, pacific);
            dfs(heights, m-1, j ,Integer.MIN_VALUE, atlantic);
        }
        
        for(int i = 0;i<m; i++) {
            dfs(heights, i, 0 ,Integer.MIN_VALUE, pacific);
            dfs(heights, i, n-1 ,Integer.MIN_VALUE, atlantic);            
        }
        
        for(int i = 0;i<m;i++)
            for(int j = 0;j<n;j++)
                if(pacific[i][j] && atlantic[i][j])
                    ans.add(Arrays.asList(i,j));
        return ans;
    }
}