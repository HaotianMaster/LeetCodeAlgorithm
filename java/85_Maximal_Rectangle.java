// Convert maximalRectangle problem to largestRectangleArea problem.
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
        int row = matrix.length; //number of row
        int col = matrix[0].length; //number of col
        int max = 0;
        int[] heights = new int[col];
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (matrix[i][j]=='1') {
                    heights[j]++;
                }
                else {
                    heights[j] = 0;
                }
            }
            int area = largestRectangleArea(heights);
            max = Math.max(max, area);
        }
        return max;
    }
    
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
