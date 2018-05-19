class Solution {
    public int rob(int[] nums) {
        if (nums.length==0) {
            return 0;
        }
        if (nums.length==1) {
            return nums[0];
        }
        if (nums.length==2) {
            return Math.max(nums[0], nums[1]);
        }
        int max = 0;
        int temp = 0;
        int prevmax = Math.max(nums[0], nums[1]);
        int prevprevmax = nums[0];
        for (int i=2; i< nums.length; i++) {
            if (prevprevmax+nums[i]>prevmax) {
                max = prevprevmax+nums[i];
                temp = prevmax;
                prevprevmax = prevmax;
                prevmax = max;
            }
            else {
                max = prevmax;
                temp = prevmax;
                prevprevmax = prevmax;
                prevmax = max;
            }
        }
        return max;
    }
}


class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int max = 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = max + nums[i];
            max = Math.max(max, dp[i-1]);            
        }
        return Math.max(dp[nums.length-2], dp[nums.length-1]);
    }
}

class Solution {
    public int rob(int[] num) {
        if (num == null || num.length == 0) return 0;
        int rob = 0, notrob = 0;
        for (int i = 0; i < num.length; i++) {
            int prev = Math.max(notrob, rob);
            rob = notrob + num[i];
            notrob = prev;
        }
        return Math.max(rob, notrob);
    }
}

class Solution {
    public int rob(int[] num) {
        int prevMax = 0;
        int currMax = 0;
        for (int x : num) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }
}