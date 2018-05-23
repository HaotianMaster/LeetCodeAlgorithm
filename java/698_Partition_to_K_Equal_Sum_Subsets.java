// Backtracking
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length == 0) return true;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) return false;
        sum = sum / k;
        Arrays.sort(nums);
        int beginIndex = nums.length - 1;
        if (nums[beginIndex] > sum) return false;
        while (beginIndex >= 0 && nums[beginIndex] == sum) {
            beginIndex--;
            k--;
        }
        return partition(new int[k], nums, beginIndex, sum);
    }
    public boolean partition(int[] subsets, int[] nums, int index, int target) {
        if (index < 0) return true;
        int curr = nums[index];
        for (int i = 0; i < subsets.length; i++) {
            if (subsets[i] + curr <= target) {
                subsets[i] += curr;
                if (partition(subsets, nums, index - 1, target)) return true;
                subsets[i] -= curr;
            }
        }
        return false;
    }
}

// Another better backtracking implementation.
// Assume sum is the sum of nums[] . 
// The dfs process is to find a subset of nums[] which sum equals to sum/k. 
// We use an array visited[] to record which element in nums[] is used. 
// Each time when we get a cur_sum = sum/k, we will start from position 0 in nums[] to look up the elements that are not used yet and find another cur_sum = sum/k.

// An corner case is when sum = 0, this method is to use cur_num to record the number of elements in the current subset. 
// Only if cur_sum = sum/k && cur_num >0, we can start another look up process.
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length == 0) return true;
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % k != 0) return false;
        sum = sum / k;
        int[] visited = new int[nums.length];
        return partition(nums, visited, 0, k, 0, 0, sum);
    }
    
    public boolean partition(int[] nums, int[] visited, int startIndex, int k, int curr_sum, int curr_num, int target) {
        if (k == 1) return true;
        if (curr_sum == target && curr_num > 0) return partition(nums, visited, 0, k-1, 0, 0, target); 
        for (int i = startIndex; i < nums.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                if (partition(nums, visited, i + 1, k, curr_sum + nums[i], curr_num++, target)) return true;
                visited[i] = 0;
            }
        }
        return false;
    }
}


