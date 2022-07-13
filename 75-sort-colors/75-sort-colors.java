class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n-1;
        
        for(int i = 0; i<=end; i++) {
            while(nums[i] == 2 && i<=end) {
                nums[i] = nums[end];
                nums[end--] = 2;
            }
            while(nums[i] == 0 && i>=start) {
                nums[i] = nums[start];
                nums[start++] = 0;
            }                            
        }
        
        
    }
}