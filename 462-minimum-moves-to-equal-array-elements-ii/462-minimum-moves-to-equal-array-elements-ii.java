class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        if(n == 0) 
            return 0;
        
        Arrays.sort(nums);
        
        int mid = 0;
        if(n % 2 == 0){
            mid = (nums[n/2] + nums[(n+1) / 2]) / 2;
        }
        else{
            mid = nums[n/2];
        }
            
        int sum = 0;
        
        for(int i=0;i<n;i++){
            sum += Math.abs(nums[i] - mid);
        }
        return sum;
    }
}