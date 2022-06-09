class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int[] cnt = new int[26];
        int max_repeat = 0;
        int max = 0;
        
        while(right< s.length()) {
            cnt[s.charAt(right) - 'A']++;
            max_repeat = Math.max(max_repeat, cnt[s.charAt(right)- 'A']);
            
            //Need to reduce the sliding window size if greater than k replacement needed
            if(right-left+1-max_repeat > k) { 
                cnt[s.charAt(left) - 'A']--;
                left++;
            }
            max = Math.max(max, right-left+1);
            right++;
        }
        return max;
    }
}