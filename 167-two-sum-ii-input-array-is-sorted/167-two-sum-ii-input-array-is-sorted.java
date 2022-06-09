class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int[] ans = new int[2];
        HashMap<Integer,Integer> hmap = new HashMap<>();
        int rem;
        
        for(int i = 0; i<n; i++) {
            rem = target - numbers[i];            
            if(hmap.containsKey(rem)) {
                ans[0] = hmap.get(rem);
                ans[1] = i+1;
                return ans;    
            }
            hmap.put(numbers[i], i+1);
        }
        return ans;
    }
}