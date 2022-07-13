class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 1)
            return 0;
        
        int left = 0;
        int right = 1;
        int profit = 0, max = 0;
        
        
        while(right<n) {
            while(right<n && prices[left] > prices[right]) {
                left = right++;
            }
            if(right<n)
                profit = prices[right++] - prices[left];
            if(max < profit)
                max = profit;
        }
        return max;
    }
}