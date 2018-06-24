// Brute force. Runtime: 218 ms
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = -1;
            for (int j = 1; j < nums.length; j++) {
                if (nums[(i + j) % nums.length] > nums[i]) {
                    res[i] = nums[(i + j) % nums.length];
                    break;
                }
            }
        }
        return res;
    }
}
// Stack, Runtime: 66 ms
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0 ; i--) {
            while (!st.isEmpty() && nums[i % nums.length] >= st.peek()) {
                st.pop();
            }
            res[i % nums.length] = st.isEmpty() ? -1 : st.peek();
            st.push(nums[i % nums.length]);
        }
        return res;
    }
}