//Count and Sort.
class Solution {
    public String reorganizeString(String S) {
        if (S == null || S.length() == 0) return "";
        int[] counts = new int[26];
        for (char ch : S.toCharArray()) counts[ch-'a'] += 100;
        for (int i = 0; i < 26; i++) counts[i] += i;
        //Encoded counts[i] = i + 100 * (actual count)
        Arrays.sort(counts);
        
        int pos = 0;
        char[] res = new char[S.length()];
        for (int i = counts.length - 1; i >= 0; i--) {
            int count = counts[i] / 100; //decode the actual count of the charater
            char ch = (char) ('a' + counts[i] % 100); //decode the charater
            if (count > (S.length() + 1) / 2) return "";
            for (int j = 0; j < count; j++) {
                if (pos >= S.length()) pos = 1;
                res[pos] = ch;
                pos += 2;
            }
        }
        return String.valueOf(res);
    }
}