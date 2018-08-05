class Solution {
    public int search(ArrayReader reader, int target) {
        int left = 0, right = Integer.MAX_VALUE;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            int num = reader.get(mid);
            if (num == Integer.MAX_VALUE) {
                right = mid - 1;
            } 
            else {
                if (num < target) {
                    left = mid;
                } 
                else if (num > target) {
                    right = mid;
                } 
                else {
                    return mid;
                }
            }
        }
        if (reader.get(left) == target) return left;
        if (reader.get(right) == target) return right;
        return -1;        
    }
}