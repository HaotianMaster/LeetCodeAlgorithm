// Sorting first and counting. My initial stupid way.

class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length==1) {
            return nums[0];
        }
        Arrays.sort(nums);
        int occu = 1;
        for (int i=0; i<nums.length-1; i++) {
            if (nums[i]==nums[i+1]) {
                occu = occu+1;
                if (occu>nums.length/2) {
                    return nums[i];
                }
            }
            else {
                occu = 1;
            }
        }
        return 0;
    }
}

// clever way of sorting method.  O(nlogn) time, O(1) space.
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}


// Hash table  O(n) time, O(n) space.
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Map.Entry<Integer, Integer> res = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (res == null || res.getValue() < entry.getValue()) {
                res = entry;
            }
        }
        return res.getKey();
    }
}

// Moore Voting
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0, res = 0;
        for (int num : nums) {
            if (count == 0) res = num;
            if (num != res) count--;
            else count++;
        }
        return res;
    }
}

//Divide and Conquer. O(logn) time, O(logn) space.

class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length==1) {
            return nums[0];
        }
        int low = 0;
        int high = nums.length-1;
        int majority = majorityElementCount(nums, low, high);
        return majority;
    }
    public int majorityElementCount(int[] nums, int low, int high) {
        if (low == high) return nums[low];
        int mid = (high-low)/2+low;
        int left = majorityElementCount(nums, low, mid);
        int right = majorityElementCount(nums, mid+1, high); 
        if (left == right) return left;
        int leftcount = countnum(nums, left, low, mid);
        int rightcount = countnum(nums, right, mid+1, high);
        if (leftcount > rightcount) return left;
        else return right;
        //If wirte as following, it won't work.
        //Therefore, I think Divide and Conquer is not correct. 
        //For example, input is [6, 5, 5].
        //if (leftcount < rightcount) return right;
        //else return left;
    }
    public int countnum(int[] nums, int num, int start, int end) {
        int count = 0;
        for (int i=start; i<=end; i++) {
            if (nums[i] == num) count++;
        }
        return count;
    }
}
