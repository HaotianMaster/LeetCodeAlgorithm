class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        Long next = Long.valueOf(lower);
        for (int i = 0; i < nums.length; i++) {
            Long curr = Long.valueOf(nums[i]);
            if (curr < next) continue;
            if (curr > Long.valueOf(upper)) continue;
            if (curr.equals(next)) {
                next++;
                continue;
            }
            res.add(getRange(next, curr - 1));
            next = curr + 1;
        }
        if (next <= upper) {
            res.add(getRange(next, Long.valueOf(upper)));
        }
        return res;
    }
    public String getRange(Long start, Long end) {
        if (start.equals(end)) {
            return String.valueOf(start);
        }
        else {
            return String.valueOf(start) + "->" + String.valueOf(end);
        }
    }
}


public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            if (upper == lower) {
                res.add(String.valueOf(lower));
            } else {
                res.add(String.valueOf(lower) + "->" + String.valueOf(upper));
            }
            return res;
        }
        
        if (nums[0] > lower) {
            helper(res, Long.valueOf(lower), Long.valueOf(nums[0]) - 1);
        }
        
        for (int i = 0; i < nums.length - 1; i++) {
            if (Long.valueOf(nums[i + 1]) - Long.valueOf(nums[i]) > 1) {
                helper(res, Long.valueOf(nums[i] + 1), Long.valueOf(nums[i + 1]) - 1);
            }
        }
        
        if (nums[nums.length - 1] < upper) {
            helper(res, Long.valueOf(nums[nums.length - 1] + 1), Long.valueOf(upper));
        }
        
        return res;
    }
    
    public void helper(List<String> list, Long start, Long end) {
        if (start== end) {
            list.add(String.valueOf(start));
        } 
        else {
            list.add(String.valueOf(start) + "->" + String.valueOf(end));
        }
    }
}