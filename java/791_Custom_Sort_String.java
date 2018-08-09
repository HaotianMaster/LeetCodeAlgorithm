class Solution {
    public String customSortString(String S, String T) {
        int[] count = new int[26];
        // count each char in T
        for (char ch : T.toCharArray()) {
            count[ch - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        // group chars both in T and S by the order of S.
        for (char ch : S.toCharArray()) {
            while (count[ch - 'a']-- > 0) sb.append(ch);
        }
        // group chars in T but not in S.
        for (int i = 0; i < 26; i++) {
            while (count[i]-- > 0) {
                char ch = (char) ('a' + i);
                sb.append(ch);
            }
        }        
        return sb.toString();
    }
}