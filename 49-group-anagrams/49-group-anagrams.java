class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hmap = new HashMap<>();
        List<List<String>> ans = new ArrayList<List<String>>();
        
        for(String str: strs) {
            char[] str_ch = str.toCharArray();
            Arrays.sort(str_ch);
            String sort = String.valueOf(str_ch);
            List<String> list = (hmap.containsKey(sort))?hmap.get(sort):new ArrayList<>();
            list.add(str);
            hmap.put(sort,list);
            }
        for( String key : hmap.keySet()){
            ans.add(hmap.get(key));
        }
        return ans;
    }
}