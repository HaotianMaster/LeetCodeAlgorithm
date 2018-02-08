class Solution {
    public String multiply(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0) return "0";
        int[] results = new int[num1.length()+num2.length()]; 
        
        for (int i=num1.length()-1; i>=0; i--) {            
            int a = num1.charAt(i) - '0';
            for (int j=num2.length()-1; j>=0; j--) {
                int b = num2.charAt(j) - '0';
                int mul = a*b+results[i+j+1];
                results[i+j+1] = mul%10;
                results[i+j] += mul/10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<results.length; i++) {
            if (!(sb.length() == 0 && results[i] == 0)) sb.append(results[i]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}