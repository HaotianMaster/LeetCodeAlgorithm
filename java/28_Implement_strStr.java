//Accepted but just for demonstrating. 
class Solution {
    public int strStr(String haystack, String needle) {
        return (haystack.indexOf(needle));
    }
}

class Solution {
    public int strStr(String haystack, String needle) {
        int i = 0; int j = 0;
        int start = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            else {
                j = 0;
                start++;
                i = start;
            }
        }
        if (j == needle.length()) return i-needle.length();
        return -1;
    }
}

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;
        int m = haystack.length();
        int n = needle.length();
        for (int i=0; i<=m-n; i++) {
            for (int j=0; j<n && haystack.charAt(i+j) == needle.charAt(j); j++) {
                if (j == n-1) return i;
            }
        }
        return -1;
    }
}