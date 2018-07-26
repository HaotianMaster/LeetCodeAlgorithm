class Solution {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) return b;
        if (b == null || b.length() == 0) return a;
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry == 1) {
            int m = i >= 0 ? a.charAt(i) - '0' : 0;
            int n = j >= 0 ? b.charAt(j) - '0' : 0;
            int curr = (m + n + carry) % 2;
            carry = (m + n + carry) / 2;
            sb.append(curr);
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
}