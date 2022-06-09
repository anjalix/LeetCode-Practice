class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a , int[]b) {
                return a[1]-b[1];
            }
        });
        int end = Integer.MIN_VALUE;
        int cnt = 0;
        for(int[] i : intervals) {
            if(end <= i[0])
            {
                end = i[1];
                cnt++;
            }
        }
        return intervals.length-cnt;
    }
}