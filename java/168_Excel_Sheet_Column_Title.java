// What we want to do is to change a base 10 number to a base 26 number.
// Only two digits.
class Solution {
    public String convertToTitle(int n) {
        StringBuilder title = new StringBuilder();
        while (n!=0) { 
            n--;
            int mod = n%26;
            title.append((char)('A'+mod));
            n = n/26;
        }        
        return title.reverse().toString();
    }
}