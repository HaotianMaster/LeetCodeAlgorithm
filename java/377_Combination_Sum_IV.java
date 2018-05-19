// DFS + Memorization
class Solution {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        return helper(nums, target, map);
    }
    public int helper(int[] nums, int target, Map<Integer, Integer> map) {       
        if (target == 0) return 1;
        if (target < 0) return 0;
        if (map.containsKey(target)) {
            return map.get(target);
        }   
        int res = 0;
        for (int num : nums) {
            res += helper(nums, target - num, map);
        }      
        map.put(target, res);
        return res;
    }
}

// DP: res[i] += res[i - num]
// O(n*k) time, O(k) space.
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] res = new int[target + 1];
        res[0] = 1;
        for (int i = 1; i < res.length; i++) {
            for (int num : nums) {
                if (i - num >= 0) {
                    res[i] += res[i - num];
                }
            }
        }
        return res[target];
    }
}