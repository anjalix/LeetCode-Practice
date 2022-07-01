class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int []>(){
            public int compare(int[] arr1, int[] arr2) {
                return (arr2[1] - arr1[1]);
            }
        });
        int ans = 0;
        for(int i = 0; i < boxTypes.length; i++) {
            if(boxTypes[i][0] <= truckSize) {
                ans = ans + (boxTypes[i][0] * boxTypes[i][1]) ;
                truckSize = truckSize - boxTypes[i][0];
            }
            else {
                ans = ans + (truckSize * boxTypes[i][1]);
                break;
            }
        }
        return ans;
    }
}
