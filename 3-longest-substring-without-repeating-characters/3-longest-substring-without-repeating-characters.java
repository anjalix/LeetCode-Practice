class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] cnt = new int[128];
        int n = s.length();
        int left = 0;
        int right = 0;
        int max = 0;
        int c;
        while(right<n) {
            c = s.charAt(right);
            cnt[c]++;
            while(cnt[c] == 2) // need to change the sliding window
            {
                cnt[s.charAt(left)]--;
                left++;
            }
            max = Math.max(right - left +1 , max);
            right++;
        }
        return max;
    }
}