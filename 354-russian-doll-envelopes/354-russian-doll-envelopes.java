class Solution {

    public int longestIncreasingSubsequenceUsingBinaryApproach(int[] arr) {
        int n = arr.length;
        int dp[] = new int[n];
        int last = 0,index= 0;
        int low = 0, high = 0, mid = 0;
        dp[0] = arr[0];


        for(int i = 1; i<n ; i++)
        {
            if(arr[i]>dp[last])
                dp[++last] = arr[i];
            else if(arr[i] < dp[0])
                dp[0] = arr[i];
            else if(arr[i]<dp[last]) {
                low = 0;
                high = last;
                index = 0;
                while(low<high)
                {
                    mid = low + (high - low)/2;
                    if(dp[mid] > arr[i]) {
                        high = mid;
                        index = mid;
                    }
                    else if(dp[mid] < arr[i]) {
                        low = mid+1;
                        index = mid+1;
                    }
                    else {
                        index = mid;
                        break;
                    }
                }
                dp[index] = arr[i];
            }
        }
        return last+1;
    }
    
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes , new Comparator<int[]>() {
            public int compare(int[] a1, int[] a2){
                if(a1[0] != a2[0])
                    return a1[0] - a2[0];
                else return a2[1] - a1[1];
            }
        });
        
        int[] arr = new int[envelopes.length];
        int i = 0;

        for(int[] e : envelopes)
            arr[i++] = e[1];
        
        return longestIncreasingSubsequenceUsingBinaryApproach(arr);
    }
}

/*
TLE if LIS is implemented through Dynamic Programming Approach.
Works fine for smaller test cases

    public int longestIncreasingSubsequence(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
       
        for(int a : arr) {
            if(!list.contains(a)) 
                list.add(a);
        }

        int[] sorted = list.stream().mapToInt(i -> i).toArray();
        Arrays.sort(sorted);

        return longestCommonSubsequence(arr, sorted);
    }
    
    public int longestCommonSubsequence(int[] a1, int[] a2) {
        int m = a1.length;
        int n = a2.length;
        int[][] dp = new int[m+1][n+1];
        
        for(int i = 0 ; i <=m ; i++) {
            for(int j = 0; j<=n; j++) {
                if(i==0 || j==0)
                    dp[i][j] = 0;
                else {
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                    if(a1[i-1] == a2[j-1])
                        dp[i][j] = Math.max((dp[i-1][j-1] + 1) , dp[i][j] );
                }
            }
        }
        return dp[m][n];
    }
    

*/