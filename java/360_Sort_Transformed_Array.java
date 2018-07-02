class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] sorted = new int[n];
        int i = 0, j = n - 1;
        int index = a >= 0 ? n - 1 : 0;
        while (i <= j) {
            int left = a * nums[i] * nums[i] + b * nums[i] + c;
            int right = a * nums[j] * nums[j] + b * nums[j] + c;
            if (a >= 0) {
                if (left >= right) {
                    sorted[index--] = left;
                    i++;
                }
                else {
                    sorted[index--] = right;
                    j--;                    
                }
            } 
            else {
                if (left >= right) {
                    sorted[index++] = right;
                    j--;
                }
                else {
                    sorted[index++] = left;
                    i++;                    
                }
            }
        }
        return sorted;
    }
}