class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int[] ans = new int[k];
        
        for(int num : nums) {
            int cnt = (hmap.containsKey(num))?(hmap.get(num)):0;
            hmap.put(num,cnt+1);
        }
        int size = hmap.size();
        List<Integer>[] freq = new List[nums.length+1];
        int i =0,max =0;
        List<Integer> element;
        for(int key : hmap.keySet())
        {
            element = (freq[hmap.get(key)]==null)? new ArrayList<>():freq[hmap.get(key)];
            element.add(key);
            freq[hmap.get(key)] = element;
            if(max <= hmap.get(key))
                max = hmap.get(key);
        }
        for( i = max; k>0 && i>=0;i--)
            if(freq[i]!= null && k>0) {
                for(int e : freq[i])
                ans[--k] = e;
            }
        return ans;
    }
}