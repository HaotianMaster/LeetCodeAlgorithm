// Brute force. AC. O(n^2) time, O(1) space.
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int max = 0;
        int sum = 0;

        for (int i=0; i<nums.length; i++) {
            for (int j=i; j<nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    max = Math.max(max, j-i+1);
                }
            }
            sum = 0;
        }
        return max;
    }
}

// HashMap, O(n) time.
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int presum = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            presum += nums[i];
            map.put(presum, map.getOrDefault(presum, i));
            if (map.containsKey(presum - k)) {
                max = Math.max(max, i - map.get(presum - k));
            }
        }
        return max;
    }
}