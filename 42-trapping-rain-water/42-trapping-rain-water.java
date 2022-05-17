class Solution {
    public int trap(int[] height) {
       int n = height.length;
       int[] left_max = new int[n];
       int[] right_max = new int[n];
        left_max[0] = height[0];
        right_max[n-1] = height[n-1];
        for(int i = 1 ;i<n;i++) {
            left_max[i] = Math.max(left_max[i-1] , height[i]);
            right_max[n-1-i] = Math.max(right_max[n-i] , height[n-i-1]);
        }
        int water = 0;
        for(int i = 0; i<n; i++){
            water += (Math.min(left_max[i],right_max[i])-height[i]);
        }
        return water;
    }
}