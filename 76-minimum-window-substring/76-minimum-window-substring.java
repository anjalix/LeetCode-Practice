class Solution {
    public String minWindow(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        String ans = "";
        
        if(tlen > slen)
            return "";
        
        int left = 0;
        
        HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
        
        for(int i = 0;i<tlen;i++) {
            hmap.put(t.charAt(i), hmap.getOrDefault(t.charAt(i),0)+1);
        }
        int count = hmap.size();
        
        while(left<slen && !hmap.containsKey(s.charAt(left)))
            left++;
        
        int right = left;
        int cnt = 0;
        int min = Integer.MAX_VALUE;
        
        while(left<=right && right<slen) {
            if(hmap.containsKey(s.charAt(right))) {
                cnt = hmap.get(s.charAt(right));
                cnt--;
                hmap.put(s.charAt(right), cnt);
                if(cnt == 0)
                    count--;
                if(count == 0 && min > right-left+1) {
                    ans = s.substring(left,right+1);
                    min = right-left+1;
                }
                while(count == 0) {
                    if(hmap.containsKey(s.charAt(left))) {
                        cnt = hmap.get(s.charAt(left));
                        cnt++;
                        hmap.put(s.charAt(left), cnt);
                        left++;
                        if(cnt > 0)
                            count++;
                    }
                    else
                        left++;
                    if(count == 0 && min > right-left+1) {
                        ans = s.substring(left,right+1);  
                        min = right-left+1;
                    }
                }
            }
            right++;                   
        }            
        return ans;        
    }
}