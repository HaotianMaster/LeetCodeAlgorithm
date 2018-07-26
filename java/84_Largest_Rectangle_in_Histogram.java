/**
 * Scan the array from left to right.
 * Store heights while they are monotically increasing. 
 * While we meet a value that is less than its previous one, we look back and calculate the area. 
 * O(n) time (actually O(2 * n) since every element is put in and take out of the deque once.).
 * O(n) space.
 * n is the length of the array.
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        if (heights == null || heights.length == 0) return res;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            if (st.isEmpty() || heights[i] >= heights[st.peek()]) {
                st.push(i);
            }
            else {
                int right = i, left = st.pop();
                int h = heights[left];
                while (!st.isEmpty() && heights[left] == heights[st.peek()]) left = st.pop();
                left = st.isEmpty() ? -1 : st.peek();
                res = Math.max(res, h * (right - left - 1));
                i--;
            }
        }
        int right = heights.length;
        while (!st.isEmpty()) {
            int left = st.pop();
            int h = heights[left];
            left = st.isEmpty() ? -1 : st.peek();
            res = Math.max(res, h * (right - left - 1));
        }
        return res;
    }
}