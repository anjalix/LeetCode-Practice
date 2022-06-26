class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int n = cardPoints.length;
        // k left score sum
        for(int i = 0; i<k; i++)
            sum = sum + cardPoints[i];
        
        // shift the slide window
        int right = k-1;
        int left = -1;
        int max = sum;

        while(right >= 0) {
            sum = sum - cardPoints[right--];
            sum = sum + cardPoints[n+left];
            left--;
            max = Math.max(max, sum);    
        }

        return max;
    }
}