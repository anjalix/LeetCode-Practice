class Solution {
    public boolean isAnagram(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chart);
        return (String.valueOf(chars).equals(String.valueOf(chart)));
    }
}