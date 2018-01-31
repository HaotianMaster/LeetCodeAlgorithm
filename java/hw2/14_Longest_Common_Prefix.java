

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<strs[0].length(); i++) {
            for (String str:strs) {
                if (str.length() >= i+1 && strs[0].charAt(i) == str.charAt(i)) {
                    continue;
                }
                else {
                    return sb.toString();
                }
            }
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }
}