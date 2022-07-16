class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i1 = 0;
        int i2 = 0;
        while(i1<m+n && i2<n) {
            if(nums1[i1] <= nums2[i2]) {
                i1++;
            }
            else {
                int t = m+n-1;
                while(t > i1) {
                    nums1[t] =nums1[t-1];
                    t--;
                }
                nums1[i1] = nums2[i2++];
            }
        }
        
        while(i2<n) {
            nums1[m+i2] = nums2[i2];
            i2++;
        }
    }
}