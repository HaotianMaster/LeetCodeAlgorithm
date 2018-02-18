class Solution {
    public String countAndSay(int n) {
        if (n <= 0) return "";
        String str = "1";
        for (int i = 1; i < n; i++) {
            int count = 0;
            Character prev = '.';
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < str.length(); j++) {
                if (j != 0 && str.charAt(j) != str.charAt(j-1)) {
                    sb.append(count);
                    sb.append(prev);
                    count = 1;
                }
                else {
                    count++;
                }
                prev = str.charAt(j);
            }
            sb.append(count);
            sb.append(prev);            
            str = sb.toString();
        }
        return str;
    }
}