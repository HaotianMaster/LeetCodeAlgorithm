class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int left = 1, right = 1000000000;
        int total = 0;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            // (p + m - 1) / m equal to ceil(p / m)
            for (int pile : piles) {
                total += (pile + mid - 1) / mid;
            }
            if (total > H) {
                left = mid;
            } 
            else {
               right = mid; 
            }
            total = 0;
        }
        for (int pile : piles) {
            total += (pile + left - 1) / left;
        }
        if (total < H) return left;
        return right;        
    }
}