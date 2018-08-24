class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean hasPoint = false;
        boolean hasE = false;
        boolean hasNum = false;
        boolean hasNumAfterE = false;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != 'e' && s.charAt(i) != '.' && s.charAt(i) != '+' && s.charAt(i) != '-') {
                return false;
            }
            else if (Character.isDigit(s.charAt(i))) {
                hasNum = true;
                hasNumAfterE = true;
            }
            else if (s.charAt(i) == 'e') {
                if (!hasNum || hasE || i == s.length() - 1) {
                    return false;
                }
                hasNumAfterE = false;
                hasE = true;
            }
            else if (s.charAt(i) == '.') {
                if (hasPoint || hasE) {
                    return false;
                }
                hasPoint = true;
            }
            else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (i != 0 && s.charAt(i-1) != 'e') return false;
            }
        }
        return hasNumAfterE && hasNum;
    }
}