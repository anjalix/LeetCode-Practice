class Solution {
    
    public boolean isPalindrome(String s, int n) {
        boolean check = true;
        char c;
        for(int i = 0; i<n/2; i++) {
            if(s.charAt(i) != s.charAt(n-i-1))
                return false;
        }
        return check;
    }
    
    public int countSubstrings(String s) {
        int n = s.length();
        int cnt = 0;
        String str;
        for(int i = 0;i<n; i++) {
            for(int j = i+1;j<=n; j++) {
                str = s.substring(i,j);
                if(isPalindrome(str, j-i))
                    cnt++;
            }
        }
        return cnt;
    }
}