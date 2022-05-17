/* Solution 2:
Priority Queue Based Implementation
*/

class KthLargest {

    private PriorityQueue<Integer> pq;
    private int k;
    
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k;
        for(int n : nums)
            pq.offer(n);
        while(pq.size()>k)
            pq.poll();        
    }
    
    public int add(int val) {
        pq.offer(val);
        while(pq.size()>k)
            pq.poll();
        return pq.peek();
    }
}
/*
Solution 1:
Array Based Approach
@aunthor: Anjali


class KthLargest {
   
    int n,k;
    int[] ans;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        n = nums.length;
        if(n<k) {
            ans = new int[n+1];
            for(int i =0;i<n;i++)
                ans[i] = nums[i];
        }
        else{
            ans = nums;            
            Arrays.sort(nums);
        }
        
    }
    
    public int add(int val) {
        if(n-k >= 0) {
        if(ans[n-k] < val)
            ans[n-k] = val;
        }
        else{
            ans[k-1] = val;
            n++;
        }
            Arrays.sort(ans);
            return ans[n-k];
    }
}

*/


/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */