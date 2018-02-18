class Solution {
    public int addDigits(int num) {
        if (num <= 9) return num;
        int sum = 0;
        while (num != 0) {
            int a = num%10;
            sum += a;
            num = num/10;
        }
        return addDigits(sum);
    }
}