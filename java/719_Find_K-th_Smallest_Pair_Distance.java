//Counting sort, Time Limit Exceeded
class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int max = 0;
        for (int num : nums) {
            if (num > max) max = num;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= max; i++) {
            map.put(i, 0);
        }
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                map.replace(Math.abs(nums[i]-nums[j]), map.get(Math.abs(nums[i]-nums[j]))+1);
            }
        }
        int sum = 0;
        for (int i = 0; i <= max; i++) {
            sum += map.get(i);
            if (sum >= k) return i;
        }
        return 0;
    }
}