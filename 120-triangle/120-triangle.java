class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int num;
        List up = triangle.get(0);
        List down;
        for(int i = size-2; i>=0 ; i--) {
            up = triangle.get(i);
            down = triangle.get(i+1);
            for(int j = 0; j<= i; j++) {
                num = (int)up.get(j);
                up.remove(j);
                up.add(j, num + Math.min((int)down.get(j), (int)down.get(j+1)));
            }
        }
        return (int)up.get(0);
    }
}