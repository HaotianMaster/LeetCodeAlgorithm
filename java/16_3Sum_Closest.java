class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int delta = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int newdelta = nums[i] + nums[start] + nums[end] - target;
                if (newdelta == 0) return target;
                if (Math.abs(newdelta) < Math.abs(delta)) {
                    delta = newdelta;
                }
                if (newdelta < 0) start++;
                else end--;
            }
        }
        return target + delta;
    }
}