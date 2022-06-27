class Solution {
    public int minPartitions(String n) {
        int c;
        int max = 0;
        int len = n.length();
        for(int i = 0; i<len; i++) {
           c = n.charAt(i) - '0';
            if(max < c)
                max = c;
        }
        return max;
    }
}