class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int missing = n;
        for(int i = 0;i<n; i++) {
            missing = missing^i;
            missing = missing^nums[i];
        }
        return missing;
    }
}