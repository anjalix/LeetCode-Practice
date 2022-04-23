class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int rem;
        int[] ans = new int[2];
        HashMap<Integer, Integer> h = new HashMap<Integer,Integer>();
        for(int i=0;i<len;i++)
        {           
            rem = target-nums[i];
            if(h.containsKey(rem)==true)
            {
                ans[0] = h.get(rem);
                ans[1] = i;
            }
            h.put(nums[i],i);            
        }        
        return ans;
    }
}