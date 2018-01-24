// O(nlogn) time, O(1) space

class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length==0 || nums.length==1) return false;
        Arrays.sort(nums);
        for (int i=0; i< nums.length-1; i++) {
            if (nums[i]==nums[i+1]) return true;
        }
        return false;
    }
}

// O(n) time, O(n) space

class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length==0 || nums.length==1) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i< nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            }
            else {
                map.put(nums[i], 1);
            }
        }
        return false;
    }
}

class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null) return false;
        HashSet<Integer> set = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            if (set.contains(nums[i])) return true;
            else set.add(nums[i]);
        }
        return false;
    }
}