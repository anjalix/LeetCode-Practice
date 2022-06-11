class Solution {
    public int minOperations(int[] nums, int x) {
        //Need to check if we can have a subarray with sum total-x
        int sum = 0;
        int n = nums.length;
        
        for(int num: nums)
            sum = sum + num;
        
        if(sum == x)
            return n;

        HashMap<Integer,Integer> hmap = new HashMap<>();
        hmap.put(0, -1);
        int s = 0;
        int ans = Integer.MIN_VALUE;
        
        for(int i = 0;i<n;i++) {
            s = s + nums[i];
            if(hmap.containsKey(s-sum+x))
                ans = Math.max(ans, i-hmap.get(s-sum+x));
            hmap.put(s,i);            
        }        
        return (ans==Integer.MIN_VALUE)?-1:n-ans;        
    }
}