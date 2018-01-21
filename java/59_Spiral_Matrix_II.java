class Solution {
    public int[][] generateMatrix(int n) {
        int[][] results = new int[n][n];
        int top = 0;
        int left = 0;
        int bot = n-1;
        int right = n-1;
        int curr = 1;
        while (left<right && top<bot) {
            for (int i=left; i<right; i++) results[top][i]=curr++;
            for (int i=top; i<bot; i++) results[i][right]=curr++;
            for (int i=right; i>left; i--) results[bot][i]=curr++;
            for (int i=bot; i>top; i--) results[i][left]=curr++;
            left++;
            right--;
            bot--;
            top++;
        }
        if (n%2!=0) results[n/2][n/2] = curr;
        return results;
    }
}