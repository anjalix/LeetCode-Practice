class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(nums[0] < nums[n-1])
            return nums[0];
        int low = 0, high = n-1,prev,next,mid;

        while(low<=high) {
            mid = (low+high)/2;
            if(mid == n-1)
                return nums[mid];
                      
            if(mid+1<n && nums[mid] > nums[mid+1])
                return nums[mid+1];

            if(mid-1>=0 && nums[mid] < nums[mid-1])
                return nums[mid];

            if(mid-1 >=0 && nums[mid-1] > nums[n-1])
                low = mid+1;

            else if(mid-1 >=0 && nums[mid-1] < nums[n-1])
                high = mid -1;
            
            else if(mid+1 < n && nums[mid+1] > nums[0])
                low = mid+1;

            else if(mid+1 < n && nums[mid+1] < nums[0])
                high = mid -1;
        }
        return nums[0];    
    }
}