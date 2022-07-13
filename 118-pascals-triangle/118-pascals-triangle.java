class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> l1 = new ArrayList<Integer>();
        List<Integer> l2 = new ArrayList<Integer>();
        l1.add(1);
        ans.add(l1);
        if(numRows == 1)
            return ans;
        int size,sum;
        for(int i = 1; i<numRows; i++) {
            l2 = l1;
            size = l2.size();
            l1 = new ArrayList<Integer>();
            l1.add(1);
            for(int j = 0; j<size-1; j++) {
                sum = l2.get(j) + l2.get(j+1);
                l1.add(sum);
            }
            l1.add(1);
            ans.add(l1);
        }
        return ans;
    }
}