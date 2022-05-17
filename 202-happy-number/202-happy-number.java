class Solution {
    
    public int sumOfDigit(int n) {
        int digit, sum = 0;
        while(n>0)
        {
            digit = n%10;
            sum = sum + digit * digit;
            n = n/10;
        }
        if(sum > 9) sum = sumOfDigit(sum);
        return sum;
    }    
    
    
    public boolean isHappy(int n) {
        int sum = sumOfDigit(n);
        return (sum == 1 || sum == 7);
    }
}