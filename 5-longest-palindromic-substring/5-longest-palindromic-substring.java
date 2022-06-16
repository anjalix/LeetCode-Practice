class Solution {
    public boolean isPalindrome(String s){
        int n = s.length();
        for(int i = 0;i<n/2;i++)
            if(s.charAt(i) != s.charAt(n-1-i))
                return false;
        
        return true;
    }
    
    public String palindrome(String s) {
        int n= s.length();
        int len;
        int max =1;
        int maxi = 0;
        int maxj = 0;
        boolean ans;
        boolean[][] dp = new  boolean[n][n];
        for(int i =n-1;i>=0;i--)
        {
             for(int j = n-1;j>=i;j--)
             {
                if(i==j) dp[i][j] = true;
                else if(j-i==1) 
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                 else
                     dp[i][j] = dp[i+1][j-1] && (s.charAt(i) == s.charAt(j));
                 
                 if(dp[i][j] == true)
                 {
                     len = j-i+1;
                        if(len > max)
                        {
                            max = len;
                            maxi = i;
                            maxj= j;
                        }
                 }
             }
        }
        return s.substring(maxi, maxj+1);   
    }
    
    public String longestPalindrome(String s) {
        int n = s.length();
        return palindrome(s);
    }
}
