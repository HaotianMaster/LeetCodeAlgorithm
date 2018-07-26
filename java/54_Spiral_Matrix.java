class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        int top = 0, left = 0, bot = matrix.length - 1, right = matrix[0].length - 1;
        while (top < bot && left < right) {
            for (int i = left; i < right; i++) res.add(matrix[top][i]);
            for (int i = top; i < bot; i++) res.add(matrix[i][right]);
            for (int i = right; i > left; i--) res.add(matrix[bot][i]);
            for (int i = bot; i > top; i--) res.add(matrix[i][left]);
            top++;
            left++;
            bot--;
            right--;
        }
        if (left == right) {
            for (int i = top; i <= bot; i++) res.add(matrix[i][right]);
        }
        else if (top == bot) {
            for (int i = left; i <= right; i++) res.add(matrix[top][i]);
        }
        return res;
    }
}