class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        if(n<2) return 0;
        int[] dp = new int[n];
        char[] str = s.toCharArray();
        int max = 0;
        
        for(int i = 0;i<n; i++) {
            if(i-1>=0 && str[i] == ')')
            {
                if(str[i-1]== '(')
                    dp[i] = ((i-2)>=0)? (dp[i-2] +2):2;
                else if(str[i-1] == ')' && (i - dp[i-1] - 1) >= 0 && str[(i - dp[i-1] - 1)] == '(')
                {
                    dp[i] = dp[i-1] + 2;
                    if((i - dp[i-1] - 2) >= 0)
                        dp[i] = dp[i] + dp[(i - dp[i-1] - 2)];
                }  
                max = Math.max(dp[i], max);
            }                           
        }
        return max;
    }
}