class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int left = 0, right = A.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[left] < A[mid] && A[mid] < A[mid + 1]) {
                left = mid;
            }
            else if (A[right] < A[mid] && A[mid] > A[mid + 1]) {
                right = mid;
            }
        }
        return A[left] > A[right] ? left : right;
    }
}