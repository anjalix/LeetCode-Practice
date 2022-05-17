class Solution {
    public int rob(int[] nums, int start, int stop) {
        int temp = 0, include = 0, exclude = 0;
        for(int i = start; i<=stop; i++)
        {
            temp = exclude;
            exclude = Math.max(include,exclude);
            include = Math.max(include,temp+nums[i]);            
        }
        return Math.max(include,exclude);
    }    
    
    
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        return Math.max(rob(nums,0,n-2), rob(nums,1,n-1));
    }
}