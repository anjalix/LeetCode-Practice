class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<Integer>();
        int n = nums.length;
        int[] ans = new int[n-k+1];
        for(int i = 0; i<n; i++) {
            while(!deque.isEmpty() && deque.peekLast() <= i-k) {
                deque.removeLast();                
            }
            while(!deque.isEmpty() && nums[deque.peekFirst()] <= nums[i]) {
                deque.removeFirst();                
            }            
            deque.addFirst(i);  
            if(i+1 >= k) {
                ans[i-k+1] = nums[deque.peekLast()];
            }
        }
        return ans;
    }
}