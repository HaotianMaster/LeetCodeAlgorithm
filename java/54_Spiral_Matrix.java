class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> results = new ArrayList<>();
        if (matrix==null || matrix.length==0 || matrix[0].length==0) return results;
        int top = 0;
        int left = 0;
        int bot = matrix.length-1;
        int right = matrix[0].length-1;
        while (left<right && top<bot) {
            for (int i=left; i<right; i++) results.add(matrix[top][i]);
            for (int i=top; i<bot; i++) results.add(matrix[i][right]);
            for (int i=right; i>left; i--) results.add(matrix[bot][i]);
            for (int i=bot; i>top; i--) results.add(matrix[i][left]);
            left++;
            right--;
            bot--;
            top++;
        }
        if (left==right) {
            for (int i=top; i<=bot; i++) results.add(matrix[i][left]);
        }
        else if (top==bot) {
            for (int i=left; i<=right; i++) results.add(matrix[top][i]);
        }
        return results;
    }
}