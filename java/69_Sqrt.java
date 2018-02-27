class Solution {
    public int mySqrt(int x) {
        if (x <= 0) return 0;
        int left = 1; int right = (int)Math.sqrt(Integer.MAX_VALUE);
        while (left+1 < right) {
            int mid = left + (right - left)/2;
            if (mid*mid > x) right = mid;
            else if (mid*mid < x) left = mid;
            else return mid;
        }
        if (right*right <= x) return right;
        return left;
    }
}

class Solution {
    public int mySqrt(int x) {
        if (x <= 0) return 0;
        int left = 1; int right = Integer.MAX_VALUE;
        while (left+1 < right) {
            int mid = left + (right - left)/2;
            if (mid > x/mid) right = mid;
            else if (mid < x/mid) left = mid;
            else return mid;
        }

        return left;
    }
}