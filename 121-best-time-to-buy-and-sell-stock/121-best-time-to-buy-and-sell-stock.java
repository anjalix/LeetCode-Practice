class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int left = 0, right = 1;
        int profit = 0;
        
        int min = 0;
        while(right<n) {
            while(right<n && prices[left] > prices[right])
            {   
                left = right++;
            }
            if( right == n )
                return min;
            profit = prices[right++]-prices[left];
            if(min < profit)
              min = profit;
        }
        return min;
    }
}