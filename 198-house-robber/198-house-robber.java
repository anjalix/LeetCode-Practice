class Solution {
    public int rob(int[] nums) {
       int last_inc = 0, last_exc = 0;
        int n = nums.length;
        for(int i = 0;i<n;i++)
        {
            if(i%2 == 0)
                last_inc = Math.max(last_exc, last_inc+nums[i]);
            else
                last_exc = Math.max(last_inc, last_exc+nums[i]);
        }
        return Math.max(last_exc,last_inc);
    }
}
