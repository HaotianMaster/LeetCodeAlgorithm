// Totally same logic with 567, just add one more defensive condition in line 23.
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() == 0 || p.length() == 0) return res;
        String s1 = p;
        String s2 = s;
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
            if (right-left+1 == s1.length() && Arrays.equals(s1Arr, s2Arr)) res.add(left);            
            right = findNextStrIdx(right+1, s1Arr, s2);
        }
        return res;      
    }
    public int findNextStrIdx(int start, int[] s1Arr, String s2) {
        while (start < s2.length()) {
            if (s1Arr[s2.charAt(start)] != 0) return start;
            start++;
        }
        return start;
    }
}

//Another solution from discusstion.
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] win = new int[256];
        int[] pFixWin = new int[256];

        if (s.length() == 0 || p.length() == 0 || p.length() > s.length()) {
            return res;
        }

        /// pre - load the pWin
        for (int i = 0; i < p.length(); i++) {
            pFixWin[p.charAt(i)]++;
        }

        // pre-load the moving  window
        for (int i = 0; i < p.length(); i++) {
            win[s.charAt(i)]++;
        }

        for (int i = 0; i < s.length(); i++) {
            // for each position check if the numbers of each letter
            // coincide in the window and the fixed window
            if (isPContainedInS(pFixWin, win)) {
                res.add(i);
            }

            // evict from the window the char we just passed in S
            // add from the S window the next character
            if ((i + p.length()) < s.length()) {
                win[s.charAt(i)]--;
                win[s.charAt(i + p.length())]++;
            } else {
                break;
            }

        }
        return res;

    }

    public boolean isPContainedInS(int[] pFixWin, int[] win) {
        for (int i = 0; i < pFixWin.length; i++) {
            if (pFixWin[i] != win[i]) {
                return false;
            }
        }
        return true;
    }
}