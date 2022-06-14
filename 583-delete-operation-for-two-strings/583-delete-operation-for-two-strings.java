class Solution {

    public int lengthOfCommonSubSequence(String word1, String word2, int len1, int len2) {
        char w1,w2;
        int[][] dp = new int[len1+1][len2+1];
        for(int i = 0; i<= len1; i++) {
            for(int j = 0; j<=len2; j++) {
                if(i == 0)
                    dp[i][j] = 0;
                else if(j == 0)
                    dp[i][j] = 0;
                else {
                    w1 =  word1.charAt(i-1);
                    w2 =  word2.charAt(j-1);
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); 
                    if(w1 == w2) {
                        dp[i][j] = Math.max(dp[i][j] , dp[i-1][j-1]+1);
                    }
                }                    
            }
        }
        return dp[len1][len2];
    }    
    
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int lenOfCommonSubSequence = lengthOfCommonSubSequence(word1, word2, len1, len2);
        return len1+len2-2*lenOfCommonSubSequence;
    }
}