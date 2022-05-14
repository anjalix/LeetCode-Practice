class Solution {    
    public int count(int n) {
        if(n<=0) 
            return 0;
        return ((n&1) + count(n>>>1));
    }
    
    public int[] countBits(int n) {
        int[] ans = new int[n+1];        
        for(int i = 0 ;i<=n; i++)
            ans[i] = count(i);       
        return ans;
    }    
}
