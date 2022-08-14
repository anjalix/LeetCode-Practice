class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int i = 0;
        int k = n-1;

        while(i+1<n && nums[i] >= nums[i+1]) {
            i++;
        }
        while(k-1>=0 && nums[k] <= nums[k-1]) {
            k--;
        }
        int max_i = Integer.MAX_VALUE;
        int max_j = Integer.MAX_VALUE;
        for(; i<=k;i++) {
            if(nums[i] > max_i && nums[i] > max_j)
                return true;
            if(max_i > nums[i]) {
                max_i = nums[i];
            }
            else if(max_j > nums[i] && nums[i]!=max_i) {
                max_j = nums[i];
            }
        }
        return false;
    }
}