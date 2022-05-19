class Solution {
    int ans = 1;
    HashMap<String, Integer> hmap = new HashMap<>();

    public void path(int[][] matrix, int i, int j, int m , int n) {
        String key = i+"_"+j;
        
        if(!hmap.containsKey(key)) {
            int cnt = 0;
            int max = 1;   
        //Up
        if(i-1>=0 && matrix[i-1][j]>matrix[i][j])
        {
            String temp = (i-1) + "_" + j; 
           if(!hmap.containsKey(temp))
            path(matrix,i-1,j,m,n);
            cnt = 1 + hmap.get(temp);
            max = Math.max(cnt,max);            
        }
        //Down
        if(i+1<m && matrix[i+1][j]>matrix[i][j])
        {
            String temp = (i+1) + "_" + j;
            if(!hmap.containsKey(temp))
            path(matrix,i+1,j,m,n);
            cnt = 1 + hmap.get(temp);
            max = Math.max(cnt,max);
        }
        //left
        if(j-1>=0 && matrix[i][j-1]>matrix[i][j])
        {
            String temp = i + "_" + (j-1);
            if(!hmap.containsKey(temp))
            path(matrix,i,j-1,m,n);
            cnt = 1 + hmap.get(temp);
            max = Math.max(cnt,max);
        }
        //Right
        if(j+1<n && matrix[i][j+1]>matrix[i][j])
        {
            String temp = i + "_" + (j+1);
            if(!hmap.containsKey(temp))
                path(matrix,i,j+1,m,n);
            cnt = 1 + hmap.get(temp);
            max = Math.max(cnt,max);
        }
        hmap.put(key,max);
        ans = Math.max(ans,max);
        }
    }
    
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0;i<m;i++)
            for(int j = 0;j<n;j++)
                path(matrix,i,j,m,n);
        for( String key : hmap.keySet())
        {
            System.out.print(key + " " + hmap.get(key));
            System.out.println();
        }
        return ans;
    }
}