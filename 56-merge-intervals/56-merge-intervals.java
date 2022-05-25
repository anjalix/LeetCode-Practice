class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int[][] output = new int[n][2];
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a1, int[] a2) {
                if(a1[0] == a2[0])
                    return a1[1] - a2[1];
                return a1[0] - a2[0];
            }
        });
        output[0][0] = intervals[0][0];
        output[0][1] = intervals[0][1];
        int index = 0; 
        for(int i = 1; i<n; i++) {
            if(output[index][1] >= intervals[i][0])
                output[index][1] = Math.max(intervals[i][1], output[index][1]);
            else {
                output[++index][0] = intervals[i][0];
                output[index][1] = intervals[i][1];
            }                
        }
        int[][] ans = new int[index+1][2];
        for(int i = 0; i<=index ;i ++) {
            ans[i][0] = output[i][0];
            ans[i][1] = output[i][1];
        }
        return ans;
    }
}