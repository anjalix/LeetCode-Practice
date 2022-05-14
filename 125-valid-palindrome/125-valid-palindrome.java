class Solution {
    
    public String formatString(String s) {
        String ans="";
        int n = s.length();
        int c;
        for(int  i=0; i<n ;i++)
        {
            c = s.charAt(i);
           if(c>=65 && c<=90)
              c = c+32;
           if((c>=97&& c<= 122) || (c>=48 && c<=57))
               ans =ans+(char)c;
        }
        return ans;
    }
    
    
    
    public boolean isPalindrome(String s) {
        String str = formatString(s);
       int n = str.length();
       int left = 0;
       int right = n-1;
        char l,r;
       while(left<right)
       {
         l = str.charAt(left++);
         r = str.charAt(right--);  
          if(l!=r)
              return false;
       }
       return true; 
    }
}