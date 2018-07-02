public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (guess(mid) == -1) right = mid;
            else if (guess(mid) == 1) left = mid;
            else return mid;
        }
        if (guess(left) == 0) return left;
        if (guess(right) == 0) return right;
        return -1;
    }
}