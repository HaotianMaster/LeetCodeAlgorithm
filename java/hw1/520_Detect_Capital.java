// My code. The logic is to exclude all the negative cases.
class Solution {
    public boolean detectCapitalUse(String word) {
        boolean hasLower = false;
        boolean firstUpper = false;
        boolean otherUpper = false;
        if (word.charAt(0)-'A' <= 25 && word.charAt(0)-'A' >= 0) firstUpper = true; 
        
        for (int i=1; i<word.length(); i++) {
            if (word.charAt(i)-'a'<=25 && word.charAt(i)-'a' >= 0) hasLower = true;
            else if (word.charAt(i)-'A' <= 25 && word.charAt(i)-'A' >= 0) otherUpper = true;
        }
        
        if (otherUpper == true && hasLower == true) return false;
        if (otherUpper == true && firstUpper == false) return false;
        return true;
    }
}
// 3 lines code in Discuss. I don't think I can wirte code like this in interview.
// The logic is to exclude all the positive cases.
public class Solution {
    public boolean detectCapitalUse(String word) {
        int cnt = 0;
        for(char c: word.toCharArray()) if('Z' - c >= 0) cnt++;
        return ((cnt==0 || cnt==word.length()) || (cnt==1 && 'Z' - word.charAt(0)>=0));
    }
}