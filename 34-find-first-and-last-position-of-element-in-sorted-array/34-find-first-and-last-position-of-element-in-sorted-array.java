class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        int index = -1;
        while(low <= high) {
            mid = (low + high)/2;
            if(nums[mid] == target) {
                index = mid;
                break;
            }
            else if(nums[mid] > target) {
                high = mid -1;
            }
            else {
                low = mid + 1;
            }            
        }
        
        int[] ans = new int[2];
        
        if(index == -1) {
            ans[0] = ans[1] = -1;
            return ans;
        }
        
        while(mid >= 0 && nums[mid] == nums[index]) {
            mid--;
        }

        ans[0] = mid+1;
        mid = index;        
        while(mid < nums.length && nums[mid] == nums[index]) {
            mid++;
        }        
        ans[1] = mid-1;        
        return ans;
        
    }
}