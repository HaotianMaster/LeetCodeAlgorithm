class Solution {
    public static String[] lessThan20 = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    public static String[] tens = new String[]{"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public static String[] thousands = new String[]{"", "Thousand", "Million", "Billion"}; 
    public String numberToWords(int num) {
        if (num == 0) return "Zero";   
        
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            if (num % 1000 != 0) {
                String temp = helper(num % 1000).trim() + " ";
                temp = temp + thousands[count] + " ";
                sb.insert(0, temp);
            }
            num /= 1000;
            count++;
        }
        return sb.toString().trim();
    }
    public String helper(int num) {
        if (num < 20) return lessThan20[num];
        else if (num < 100) {
            return tens[num / 10] + " " + lessThan20[num % 10];
        }
        else {
            return lessThan20[num / 100] + " " + "Hundred" + " " + helper(num % 100);
        }
    }
}