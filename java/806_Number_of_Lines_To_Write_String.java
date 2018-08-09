class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        int num_of_lines = 1, units = 0;
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            units += widths[ch - 'a'];
            if (units > 100) {
                num_of_lines++;
                units = 0;
                units += widths[ch - 'a'];
            }
        }
        return new int[]{num_of_lines, units};
    }
}