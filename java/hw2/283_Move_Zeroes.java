//Approach #1 (Space Sub-Optimal) [Accepted]

class Solution {
    public void moveZeroes(int[] nums) {
        int numOfZeros = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i]==0) {
                numOfZeros = numOfZeros+1;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<nums.length; i++) {
            if (nums[i]!=0) {
                q.add(nums[i]);
            }
        }
        for (int i=0; i<numOfZeros; i++) {
            q.add(0);
        }
        for (int i=0; i<nums.length; i++) {
            nums[i] = q.remove();
        }
    }
}

//Approach #2 (Space Optimal, Operation Sub-Optimal) [Accepted]

class Solution {
    public void moveZeroes(int[] nums) {
        int lastnonzero = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i]!=0) {
                nums[lastnonzero++] = nums[i];
            }
        }
        for (int i=lastnonzero; i<nums.length; i++) {
            nums[i] = 0;
        }
    }
}



//Approach #3 (Optimal) [Accepted]

class Solution {
    public void moveZeroes(int[] nums) {
        int lastnonzero = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i]!=0) {
                int temp = nums[lastnonzero];
                nums[lastnonzero++] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
