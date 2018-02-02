class Solution {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0) return num2;
        if (num2 == null || num2.length() == 0) return num1;
        int i = num1.length()-1;
        int j = num2.length()-1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (i >= 0 || j >= 0 || carry == 1) {
            int a = i >= 0 ? num1.charAt(i) - '0' : 0;
            i--;
            int b = j >= 0 ? num2.charAt(j) - '0' : 0;
            j--;
            if (a+b+carry>9) {
                sb.append(a+b+carry-10);
                carry = 1;
            }
            else {
                sb.append(a+b+carry);
                carry = 0;
            }
        }
        return sb.reverse().toString();
    }
}
// Better implementation.
class Solution {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0) return num2;
        if (num2 == null || num2.length() == 0) return num1;
        int i = num1.length()-1;
        int j = num2.length()-1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (i >= 0 || j >= 0 || carry == 1) {
            int a = i >= 0 ? num1.charAt(i) - '0' : 0;
            i--;
            int b = j >= 0 ? num2.charAt(j) - '0' : 0;
            j--;
            sb.append((a+b+carry)%10);
            carry = (a+b+carry)/10;
        }
        return sb.reverse().toString();
    }
}