class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int start = 0;
        int end = n-1;
        int max = 0;
        
        while(start<end) {
            if(height[start] <= height[end]) {
              max = Math.max(max , height[start]*(end - start));
              start++;  
            }
            else {
              max = Math.max(max , height[end]*(end - start));
              end--; 
            }
        }
        return max;
    }
}