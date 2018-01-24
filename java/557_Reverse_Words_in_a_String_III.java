// toCharArray()
class Solution {
    public String reverseWords(String s) {
        char[] str = s.toCharArray();
        int i = 0;
        for (int j=0; j<str.length; j++) {
            if (str[j] == ' ') {
                reverse(str, i, j-1);
                i = j+1;
            }
        }
        reverse(str, i, s.length()-1);
        return String.valueOf(str);
    }
    public void reverse(char[] str, int i, int j) {
        while (i<j) {
            char temp = str[i];
            str[i++] = str[j];
            str[j--] = temp;            
        }
    }
}

// StringBuilder()
class Solution {
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        for (int i=0; i<str.length; i++) {
            str[i] = new StringBuilder(str[i]).reverse().toString();
        }
        StringBuilder sb = new StringBuilder();
        for (String curr:str) {
            sb.append(curr + " ");
        }  
        return sb.toString().trim();
    }
}