// Two pointer. O(n) time, O(p+q) space. 
class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) list1.add(i);           
            if (words[i].equals(word2)) list2.add(i);
        }
        int p1 = 0, p2 = 0;
        int res = Integer.MAX_VALUE;
        while (p1 < list1.size() && p2 < list2.size()) {
            int a1 = list1.get(p1);
            int a2 = list2.get(p2);
            res = Math.min(res, Math.abs(a1 - a2));
            if (a1 < a2) p1++;
            else p2++;
        }
        return res;
    }
}

// Optimized two pointer, still O(n) time, but O(1) space.
class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int res = Integer.MAX_VALUE;
        int idx1 = -1, idx2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                idx1 = i;
                if (idx2 != -1) res = Math.min(res, Math.abs(idx1 - idx2));
            }
            else if (words[i].equals(word2)) {
                idx2 = i;
                if (idx1 != -1) res = Math.min(res, Math.abs(idx1 - idx2));
            }
        }
        return res;
    }
}