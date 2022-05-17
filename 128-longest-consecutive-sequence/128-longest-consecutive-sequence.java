class Solution {
    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        if(len<=1)
            return len;
        Arrays.sort(nums);
        int max = 1;
        int consecutive_ending_here = 1;
        for(int i = 1; i < len; i++) {
            if(nums[i] - nums[i-1] == 1)
                consecutive_ending_here++;
            else if(nums[i] - nums[i-1] != 0)
                consecutive_ending_here = 1;
            if(max < consecutive_ending_here) 
                max = consecutive_ending_here;
        }
        return max;
    }
}