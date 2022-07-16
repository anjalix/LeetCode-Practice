
class Solution {        
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][] dp = new int[m][n];
        int[][] temp;
        dp[startRow][startColumn] = 1;
        int count = 0;
        int M = 1000000007;
        
        for(int move = 0; move<maxMove; move++) {
            temp = new int[m][n];
            for(int i = 0; i<m; i++) {
                for(int j = 0; j<n; j++) {
                    if(i == 0) count = (count + dp[i][j])%M;
                    if(i == m-1) count = (count + dp[i][j])%M;
                    if(j == 0) count = (count + dp[i][j])%M;
                    if(j == n-1) count = (count + dp[i][j])%M;
                    
                    temp[i][j] = ((((((i-1>=0)?dp[i-1][j]:0) + 
                        ((i+1<m)?dp[i+1][j]:0))%M +
                        ((j-1>=0)?dp[i][j-1]:0))%M +
                        ((j+1<n)?dp[i][j+1]:0)))%M;
                }
            }
            dp = temp;
        }
        return count;
    }
}


/*
BruteForce

class Solution {        
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if(startRow == -1 || startRow == m || startColumn == -1 || startColumn == n) {
            return 1;
        }
        if(maxMove <= 0) {
            return 0;
        }
        else return findPaths(m, n, maxMove-1, startRow-1, startColumn) + 
            findPaths(m, n, maxMove-1, startRow, startColumn-1) +
            findPaths(m, n, maxMove-1, startRow+1, startColumn) +
            findPaths(m, n, maxMove-1, startRow, startColumn+1);        
    }
}
*/