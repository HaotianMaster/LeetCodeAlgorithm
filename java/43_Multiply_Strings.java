class Solution {
    public String multiply(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0) return "0";
        int[] result = new int[num1.length() + num2.length()];
        
        for (int i = num1.length() - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                int mul = a * b + result[i + j + 1];
                //update low pos
                result[i + j + 1] = mul % 10;
                //update high pos
                result[i + j] += mul / 10;                
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (!(sb.length() == 0 && result[i] == 0)) sb.append(result[i]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
