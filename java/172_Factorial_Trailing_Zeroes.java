class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        for (; n > 0; n /= 5) {
            res += n / 5;
        }
        return res;
    }
}