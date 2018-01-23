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
        int maxarea = 0;
        if (heights==null||heights.length == 0) return maxarea;
        Stack<Integer> st = new Stack<>();
        for (int i=0; i<heights.length; i++) {
            if (st.empty() || heights[i]>=heights[st.peek()]) {
                st.push(i);
            }
            else {
                int rightmost = i;
                int leftmost = st.pop();
                int h = heights[leftmost];
                while (!st.empty() && heights[leftmost]==heights[st.peek()]) leftmost = st.pop();
                leftmost = (st.empty()) ? -1 : st.peek();
                maxarea = Math.max(maxarea, h*(rightmost-leftmost-1));
                i--;
            }
        }
        int rightmost = st.peek()+1;
        while (!st.empty()) {
            int curr = st.pop();
            int h = heights[curr];
            int leftmost = (st.empty()) ? -1 : st.peek();
            maxarea = Math.max(maxarea, h*(rightmost-leftmost-1));
        }
        return maxarea;
    }
}
