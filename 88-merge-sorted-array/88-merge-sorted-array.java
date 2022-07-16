class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int end = m-1;
        int i1= 0, i2 = 0;
        
        while(i1<m+n && i2<n) {
            if(i1 > end) {
                nums1[i1] = nums2[i2];
                i1++;
                i2++;
            }
            else if(nums1[i1] <= nums2[i2]) {
                i1++;
            }
            else if(nums1[i1] > nums2[i2]) {
                int t = m+n-1;
                while(t>i1) {
                    nums1[t] = nums1[t-1];
                    t--;
                }
                end++;
                nums1[i1++] = nums2[i2++];
            }
        }
    }
}