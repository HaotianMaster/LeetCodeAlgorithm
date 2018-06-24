class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length<4) return results;
        Arrays.sort(nums);
        for (int i=0; i<nums.length-3; i++) {
            int targetforthreesum = target-nums[i];
            int j = i+1;
            List<List<Integer>> mlists = threeSum(nums, j, targetforthreesum);
            for (int k=0; k<mlists.size(); k++) {
                mlists.get(k).add(nums[i]);
                results.add(mlists.get(k));
            }
            while (i <= nums.length-3 && nums[i] == nums[i+1]) i++;
        }
        return results;
    }
    public List<List<Integer>> threeSum(int[] nums, int j, int targetforthreesum) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i=j; i<nums.length-2; i++) {
            int target = targetforthreesum-nums[i]; 
            int left = i+1; 
            int right = nums.length-1; 
            while (left<right) {
                if (nums[left]+nums[right]==target) {
                    List<Integer> templist = new ArrayList<>();
                    templist.add(nums[i]);
                    templist.add(nums[left]);
                    templist.add(nums[right]);
                    lists.add(templist);
                    while (left < nums.length-1 && nums[left]==nums[left+1]) left++;
                    while (right > 0 && nums[right]==nums[right-1]) right--;
                    left++;
                    right--;
                }
                else if (nums[left]+nums[right]<target) left++;
                else right--;
            }
            while (i <= nums.length-2 && nums[i]==nums[i+1]) i++;
        }
        return lists;
    } 
}

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) return res;
        Arrays.sort(nums);
        if (nums[0] > 0 || nums[nums.length - 1] < 0) return res;
        for (int i = 0; i < nums.length - 3; i++) {
            int the_target = target - nums[i];
            for (int j = i + 1; j < nums.length - 2; j++) {
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (nums[j] + nums[left] + nums[right] == the_target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left]==nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    }
                    else if (nums[j] + nums[left] + nums[right] < the_target) {
                        left++;
                    }
                    else {
                        right--;
                    }
                }
                while (j + 1 < nums.length - 2 && nums[j] == nums[j + 1]) j++;
            }
            while (i + 1 < nums.length - 3 && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }
}





