class Solution {
    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        int[] diff = new int[n];
        int cnt = 0;
        for(int i = 1; i<n; i++) {
            diff[i] = nums[i] - nums[i-1];
            if(diff[i] < 0) {
                cnt++; 
                if(i != n-1 && i!=1) {
                    if(nums[i+1] < nums[i-1] && (diff[i-1] + diff[i])<0)
                        return false;
                }
            }
        }
        return cnt<=1;
    }
}
