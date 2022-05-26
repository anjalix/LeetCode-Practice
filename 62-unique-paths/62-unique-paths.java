class Solution {

    public int factorial(int sum, int max) {
        double pro = 1;        
        for(int i = max+1; i<=sum ; i++)
            pro = pro * i;        
        for(int i = 1 ; i<=(sum-max) ; i++)
            pro = pro/i;        
        return (int)pro;
    }    
    
    
    
    public int uniquePaths(int m, int n) {
       int max = m;
        if(m<n)
            max = n;
        return factorial(m+n-2, max-1);
    }
}