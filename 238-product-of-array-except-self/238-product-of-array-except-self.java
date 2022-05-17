class Solution {
    public int[] productExceptSelf(int[] nums) {
        int cnt0 = 0;
        int product = 1;
        for(int i : nums){
            if(i == 0)
                cnt0++;
            else product = product*i;
        }
        int n = nums.length;
        int[] max = new int[n];
        if(cnt0>1) return max;
        
        for(int i = 0; i<n; i++){
            if(cnt0 == 1) {
                if(nums[i] == 0)
                    max[i] = product;
            }
            else
                max[i] = product/nums[i];        
        }
        return max;
    }
}