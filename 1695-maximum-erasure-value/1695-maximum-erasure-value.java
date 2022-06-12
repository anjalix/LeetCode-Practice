class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        
        while(left<=right && right<n) {
            if(!hmap.containsKey(nums[right])) {                
                sum = sum + nums[right];
                hmap.put(nums[right], right);
                max = Math.max(max,sum);
                right++;
            }
            else{
                hmap.remove(nums[left]);
                sum = sum - nums[left];
                left++;
            }            
        }
        return max;        
    }
}