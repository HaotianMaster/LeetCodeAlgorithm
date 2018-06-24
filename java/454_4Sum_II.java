class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int numA : A) {
            for (int numB : B) {
                map.put(numA + numB, map.getOrDefault(numA + numB, 0) + 1);
            }
        }
        
        int res = 0;
        for (int numC : C) {
            for (int numD : D) {
                res += map.getOrDefault(-1 * (numC + numD), 0);
            }
        }        
        
        return res;
    }
}