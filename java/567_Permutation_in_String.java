//My solution.
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s1.length() == 0 || s1.length()>s2.length()) return false;
        int[] s1Arr = new int[256];
        int[] s2Arr = new int[256];
        for (char ch : s1.toCharArray()) {
            s1Arr[ch]++;
        }
        int left = findNextStrIdx(0, s1Arr, s2);
        int right = left;
        while (right < s2.length()) {
            if (right-left+1 > s1.length()) {
                char leftchar = s2.charAt(left);
                s2Arr[leftchar]--;
                left = findNextStrIdx(left+1, s1Arr, s2);
            }
            char rightchar = s2.charAt(right);
            s2Arr[rightchar]++;
            if (Arrays.equals(s1Arr, s2Arr)) return true;            
            right = findNextStrIdx(right+1, s1Arr, s2);
        }
        return false;
    }
    
    public int findNextStrIdx(int start, int[] s1Arr, String s2) {
        while (start < s2.length()) {
            if (s1Arr[s2.charAt(start)] != 0) return start;
            start++;
        }
        return start;
    }
}