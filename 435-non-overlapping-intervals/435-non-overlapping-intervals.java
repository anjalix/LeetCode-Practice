/*
Solution 2
Sorting on the basis of starting
*/
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> (a[0]-b[0]));
        int n = intervals.length;
        int cnt = 1;
        int curr = 0;
        int next = 1;
        
        while(next < n) {
            //Case 1: Non Overlapping
            // End of curr is less or equal to start of next
            if(intervals[curr][1] <= intervals[next][0]) {
                curr = next;
                cnt++;
                next++;
            }
            //Case 2: Overlapping Case
            // End of curr is more than start of next
            else if(intervals[curr][1] > intervals[next][0]) {
                if(intervals[next][1] < intervals[curr][1])
                curr = next;
                next++;
            }                        
        }
        return n-cnt;
        
    }
}



/*
Solution 1
Sorting on the basis of ending

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

*/