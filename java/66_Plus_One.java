// By default java will initialize the whole array as 0. If we come to final stage of the code, we can be sure that the number was 99999*** something, 
// so we can safely just change the first digit to 1 and leave all the rest 0.

class Solution {
    public int[] plusOne(int[] digits) {
        for (int i=digits.length-1; i>=0; i--) {
            if (digits[i] + 1 < 10) {
                digits[i] += 1;
                return digits;
            }
            else {
                digits[i] = 0;
            }
        }
        // For example, 99 + 1 = 100
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;        
    }
}