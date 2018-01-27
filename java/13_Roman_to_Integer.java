
//I   V   X    L    C    D    M    IV  IX   XL   XC   CD    CM
//1   5   10   50  100  500  1000  4   9    40   90   400   900
//143: CXLIII  133: CXXXIII 193: CXCIII  173: CLXXIII  393: CCCXCIII

class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        if (s == null || s.length() == 0) return sum;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == 'I') sum += 1;
            if (s.charAt(i) == 'V') sum += 5;
            if (s.charAt(i) == 'X') sum += 10;
            if (s.charAt(i) == 'L') sum += 50;
            if (s.charAt(i) == 'C') sum += 100;
            if (s.charAt(i) == 'D') sum += 500;
            if (s.charAt(i) == 'M') sum += 1000;
        }
        if (s.indexOf("IV") != -1) sum -= 2;
        if (s.indexOf("IX") != -1) sum -= 2;
        if (s.indexOf("XL") != -1) sum -= 20;
        if (s.indexOf("XC") != -1) sum -= 20;
        if (s.indexOf("CD") != -1) sum -= 200;
        if (s.indexOf("CM") != -1) sum -= 200;
        return sum;
    }
}