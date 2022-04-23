class Solution {
    public int lengthOfLastWord(String s) {
        String[] str = s.split(" ");
        int len = str.length;
        return str[len-1].length();
    }
}