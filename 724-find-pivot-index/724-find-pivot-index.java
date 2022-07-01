class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i<n; i++) {
            sum = sum + nums[i];
        }
        
        int half = 0;
        for(int i = 0; i<n ; i++) {
            if((sum-nums[i])%2==0 && half == (sum-nums[i])/2)
                return i;
            half = half + nums[i];
        }
       return -1; 
    }
}  
  