class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] jump = new int[n];
        jump[0] = cost[0];
        jump[1] = cost[1];
        for(int i = 2; i<n;i++)
            jump[i] = cost[i] + Math.min(jump[i-1] , jump[i-2]);
        return Math.min(jump[n-1],jump[n-2]);
    }
}