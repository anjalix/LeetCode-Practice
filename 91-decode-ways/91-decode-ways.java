class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(s.charAt(0) == '0')
            return 0;
        
        int[] dp = new int[n+1];
        int curr = 0,last = 0;
        
        dp[0] = 1;
        for(int i = 0; i<n; i++) {
            if(i==0) {
                curr = s.charAt(i) -'0';
                if(curr > 0)
                    dp[i+1] = dp[i+1] + dp[i];
                else return 0;
            }
            else {
                last = curr;
                curr = s.charAt(i) - '0';
                
                if(curr > 0)
                    dp[i+1] = dp[i+1] + dp[i];
                
                if(last*10+curr >=10 && last*10+curr <=26)
                    dp[i+1] = dp[i+1] + dp[i-1];
                
                if(dp[i+1] == 0)
                    return 0;
            }
        }
        return dp[n];
    }
}