//The difference between this question and the previous question is that this question allows similarlity transition. 
//Hence the relationship of pairs[][] actually builds a graph.

// DFS
// Time complexity: O(np) where n is the length of words1[] or words2[]. p is the length of pairs[][].
// Space complexity: O(p)
class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;
        int len = words1.length;
        Map<String, HashSet<String>> map = new HashMap<>();
        for (String[] pair : pairs) {
            if (!map.containsKey(pair[0])) {
                map.put(pair[0], new HashSet<>());
            }
            if (!map.containsKey(pair[1])) {
                map.put(pair[1], new HashSet<>());
            }
            map.get(pair[0]).add(pair[1]);
            map.get(pair[1]).add(pair[0]);
        }
    
        for (int i = 0; i < len; i++) {
            if (!words1[i].equals(words2[i]) && (!dfs(words1[i], words2[i], map, new HashSet<>()))) return false;
        } 
        return true;
    }
    public boolean dfs(String s1, String s2, Map<String, HashSet<String>> map, Set<String> visiting) {
        if (!map.containsKey(s1)) return false;
        if (s1.equals(s2)) return true;
        visiting.add(s1);
        for (String next : map.get(s1)) {
            if (!visiting.contains(next) && dfs(next, s2, map, visiting)) return true;
        }
        return false;
    }
}

// BFS
// Time complexity: O(np) where n is the length of words1[] or words2[]. And p is the number of pairs in pairs[][] since for each word in words1, we need to search through the graph.
// Space complexity: O(p)
class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;
        int len = words1.length;
        Map<String, HashSet<String>> map = new HashMap<>();
        for (String[] pair : pairs) {
            if (!map.containsKey(pair[0])) {
                map.put(pair[0], new HashSet<>());
            }
            if (!map.containsKey(pair[1])) {
                map.put(pair[1], new HashSet<>());
            }
            map.get(pair[0]).add(pair[1]);
            map.get(pair[1]).add(pair[0]);
        }
    
        for (int i = 0; i < len; i++) {
            if (!words1[i].equals(words2[i]) && (!bfs(words1[i], words2[i], map, new HashSet<>()))) return false;
        } 
        return true;
    }
    public boolean bfs(String s1, String s2, Map<String, HashSet<String>> map, Set<String> visiting) {
        if (!map.containsKey(s1)) return false;
        Queue<String> queue = new LinkedList<>();
        visiting.add(s1);
        queue.add(s1);
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (curr.equals(s2)) return true;
            for (String next : map.get(curr)) {
                if (!visiting.contains(next) && map.containsKey(next)) {
                    visiting.add(next);
                    queue.add(next);
                }
            }
        }
        return false;
    }
}






