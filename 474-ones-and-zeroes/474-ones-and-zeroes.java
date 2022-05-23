class Solution {
public int findMaxForm(String[] ss, int m, int n) {
        int l = ss.length, dp[][] = new int[m + 1][n + 1];
        for (String s : ss) {
            int one = 0, zero = 0;
            for (char c : s.toCharArray()) {
                if (c == '1') one++;
                else zero++;
            }
            for (int i = m; i >= zero; i--) {
                for (int j = n; j >= one; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
                }
            }
        }
        return dp[m][n];
    }
}


