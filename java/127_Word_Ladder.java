// BFS
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) return 0;
        int level = 1;
        boolean ladder = false;
        Map<String, List<String>> map = new HashMap<>();
        buildMap(beginWord, wordList, map);
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.offer(beginWord);
        set.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(endWord)) return level;
                List<String> list = map.get(curr);
                for (String str : list) {
                    if (set.contains(str)) continue;
                    queue.offer(str);
                    set.add(str);
                }
            }
            level++;
        }
        return 0;
    }
    
    public void buildMap(String beginWord, List<String> wordList, Map<String, List<String>> map) {
        for (String str : wordList) {
            List<String> list = new ArrayList<>();
            map.put(str, list);
            for (String nxt : wordList) {
                if (numberOfDiff(str, nxt) == 1) {
                    map.get(str).add(nxt);
                }
            }
        }
        
        if (!map.containsKey(beginWord)) {
            List<String> list = new ArrayList<>();
            map.put(beginWord, list);
            for (String nxt : wordList) {
                if (numberOfDiff(beginWord, nxt) == 1) {
                    map.get(beginWord).add(nxt);
                }
            }            
        }
    }
    
    public int numberOfDiff(String word1, String word2) {
        int ans = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) ans++;
        }
        return ans;
    }
}




