class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();
        // If either one is negative (not both)
        if (numerator < 0 ^ denominator < 0) sb.append("-");
        // Convert to Long or else abs(-2147483648) overflows
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        sb.append(String.valueOf(dividend / divisor));
        long remainder = dividend % divisor;
        // Answer is a whole integer, should not contain the fractional part.
        if (remainder == 0) return sb.toString();
        // Answer is not a whole integer.
        sb.append(".");       
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                sb.insert(map.get(remainder), "(");
                sb.append(")");
                break;
            }
            map.put(remainder, sb.length());
            remainder *= 10;
            sb.append(remainder / divisor);
            remainder %= divisor;
        }   
        return sb.toString();
    }
}