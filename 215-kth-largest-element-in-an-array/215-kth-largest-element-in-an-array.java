class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(((a,b)->b-a));
        for(int num : nums) {
            pq.add(num);
        }
        int n = nums[0];

        for(int i = 0; i<k; i++)
            n = pq.remove();
        
        return n;
    }    
}