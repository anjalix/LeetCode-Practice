class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        
        if(n == 1) return 1;
        if(n == 2 && nums[0] == nums[1]) return 1;
        
        int[] diff = new int[n-1];
        
        for(int i = 0;i<n-1;i++) {
            diff[i] = nums[i+1] - nums[i];
        }
        
        int cnt = n;
        int last = diff[0];        
        for(int i = 0;i<n-1;i++) {
            if(diff[i] == 0) {
                cnt--;
                continue;
            }
            else if(i==0) {
                last = diff[i];                
            }
            else {
                if(last * diff[i] < 0) {
                    last = diff[i];
                }
                else if(last!=0 && last * diff[i]>=0 )
                    cnt--;
            }
        }
        return cnt;
    }
}