class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i = n-1;i>=0;i--) {
           if(digits[i] == 9)
               digits[i] = 0;
           else
           {
               digits[i]++;
               break;
           }
       }
            if(digits[0] != 0)
                return digits;
            else
            {
                int[] ans = new int[n+1];
                ans[0] = 1;
                return ans;
            }
        }
    }