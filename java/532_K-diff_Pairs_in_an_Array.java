class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k < 0) return 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num:nums) {
            if (map.containsKey(num)) map.replace(num, map.get(num)+1);
            else map.put(num, 1);
        }

        //Iterator iterator = map.keySet().iterator();
        for (int key:map.keySet()) {
            //int key = (int)iterator.next();
            if (k == 0) {
                if (map.get(key) >= 2) count++;
            }
            else if (map.containsKey(key+k)) count++;
        }   
        return count;
    }
}