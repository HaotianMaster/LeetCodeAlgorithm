class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> summary = new ArrayList<>();
        if (nums == null || nums.length == 0) return summary;

        int start = nums[0];
        int end = nums[0];
        for (int i=1; i<nums.length; i++) {
            if (nums[i]-end==1) {
                end = nums[i];
            }
            if (nums[i]-1>end && start==end) {
                summary.add(start + "");
                start = nums[i];
                end = nums[i];
            }
            if (nums[i]-1>end && start!=end) {
                summary.add(start + "->" + end);
                start = nums[i];
                end = start;
            }
        }
        summary.add(start==end ? start + "" : start + "->" + end);
        return summary;
    }
}
