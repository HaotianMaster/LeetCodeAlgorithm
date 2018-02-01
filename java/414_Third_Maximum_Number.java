/*
 * Input:
 * [-2147483648,-2147483648,-2147483648,-2147483648,1,1,1]
 * Output: -2147483648
 * Expected: 1
 */
class Solution {
    public int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer num:nums) {
            if (num == max1 || num == max2 || num == max3) continue;
            if (max1 == null || num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            }
            else if (max2 == null || num > max2) {
                max3 = max2;
                max2 = num;
            }
            else if (max3 == null || num > max3) {
                max3 = num;
            }
        }
        return max3 == null ? max1 : max3;
    }
}

// error: incompatible types: <null> cannot be converted to int
class Solution {
    public int thirdMax(int[] nums) {
        int max1 = null;
        int max2 = null;
        int max3 = null;
        for (int num:nums) {
            if (num.equals(max1) || num.equals(max2) || num.equals(max3)) continue;
            if (max1 == null || num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            }
            else if (max2 == null || num > max2) {
                max3 = max2;
                max2 = num;
            }
            else if (max3 == null || num > max3) {
                max3 = num;
            }
        }
        return max3 == null ? max1 : max3;
    }
}

// Accepted.
class Solution {
    public int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer num:nums) {
            if (num.equals(max1) || num.equals(max2) || num.equals(max3)) continue;
            if (max1 == null || num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            }
            else if (max2 == null || num > max2) {
                max3 = max2;
                max2 = num;
            }
            else if (max3 == null || num > max3) {
                max3 = num;
            }
        }
        return max3 == null ? max1 : max3;
    }
}

// Accepted. 
class Solution {
    public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        HashSet<Integer> set = new HashSet<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num:nums) {
            if (!set.contains(num)) {
                set.add(num);
                pq.add(num);
                if (pq.size() > 3) {
                    pq.poll();
                }                
            }
        }
        if (pq.size() < 3) {
            while (pq.size() > 1) pq.poll();
        }
        return pq.peek();
    }
}