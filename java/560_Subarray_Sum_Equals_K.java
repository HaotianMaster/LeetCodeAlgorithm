// O(n^2) using optimized brute force.
class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int presum = 0;
            for (int j = i; j < nums.length; j++) {
                presum += nums[j];
                if (presum == k) res++;
            }
        }
        return res;
    }
}

// O(n) using HashMap + presum. 
class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int presum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            presum += num;
            res += map.getOrDefault(presum - k, 0);
            map.put(presum, map.getOrDefault(presum, 0) + 1);
        }
        return res;
    }
}