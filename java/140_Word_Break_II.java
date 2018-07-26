// Time Limit Exceeded. Using DFS directly without memoization.
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        wordBreakHelper(res, s, wordDict, 0, "");
        return res;
    }
    public void wordBreakHelper(List<String> res, String s, List<String> wordDict, int pos, String sentence) {
        if (pos == s.length()) {
            res.add(sentence);
            return;
        }
        for (int i=pos; i<s.length(); i++) {
            String currWord = s.substring(pos, i+1);
            if (wordDict.contains(currWord)) {
                if (pos == 0) wordBreakHelper(res, s, wordDict, i+1, currWord);
                else wordBreakHelper(res, s, wordDict, i+1, sentence + " " + currWord);
            }          
        }
    }
}

// Use HashMap to save the previous results to prune duplicated branches.
// DFS/Backtracking with memoization.
class Solution {
    Map<Integer, List<String>> map = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreakHelper(s, wordDict, 0);
    }
    public List<String> wordBreakHelper(String s, List<String> wordDict, int pos) {
        if (map.containsKey(pos)) {
            return map.get(pos);
        }
        List<String> res = new ArrayList<>();
        if (pos == s.length()) {
            res.add("");
        }
        for (int i = pos; i < s.length(); i++) {
            String word = s.substring(pos, i + 1);
            if (wordDict.contains(word)) {
                List<String> list = wordBreakHelper(s, wordDict, i + 1);
                for (String str : list) {
                    String curr = str.equals("") ? word : word + " " + str;
                    res.add(curr);
                }
            }
        }
        map.put(pos, res);
        return res;
    }
}
