class Solution {
    public boolean hasAllCodes(String s, int k) {
        int count = 1<<k;
        int n = s.length();
//If length is insufficient
        if(n < count+k-1)
            return false;
//If the string has all 0s or all 1s        
       if(!(s.indexOf('0')>=0 && s.indexOf('1')>=0))
            return false;

        Set<String> subs = new HashSet<String>();        
        for(int i = 0;i<=n-k;i++){
            String str = s.substring(i,i+k);
            if(!subs.contains(str)) {
                subs.add(str);
                count--;                
                if(count == 0)
                    return true;
            }         
        }
        return false;
    }
}