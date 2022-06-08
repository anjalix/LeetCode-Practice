class Solution {
    
    public boolean isPalindrome(String s) {
        int len = s.length();
        for(int i = 0; i<len/2 ; i++) {
            if(s.charAt(i) != s.charAt(len-i-1))
                return false;
            }
        return true;
    }
    
    public int removePalindromeSub(String s) {
        return (isPalindrome(s))?1:2;
    }
}

