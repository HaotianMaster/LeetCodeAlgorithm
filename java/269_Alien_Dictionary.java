class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();
        Map<Character, Integer> indegree = new HashMap<Character, Integer>();
        String res = "";
        if (words == null || words.length == 0) return res;
        for (String word: words){
            for (char ch: word.toCharArray()){
                indegree.put(ch, 0);
            }
        }
        for (int i = 0; i < words.length - 1; i++){
            String curr = words[i];
            String next = words[i+1];
            int length = Math.min(curr.length(), next.length());
            for (int j = 0; j < length; j++){
                char c1 = curr.charAt(j);
                char c2 = next.charAt(j);
                if (c1 != c2) {
                    if (!map.containsKey(c1)) map.put(c1, new HashSet<>());
                    if (map.get(c1).add(c2)) {
                        indegree.put(c2, indegree.get(c2) + 1);
                    }
                    break;
                }
            }
        }
        Queue<Character> queue = new LinkedList<>();
        for (char ch: indegree.keySet()){
            if (indegree.get(ch) == 0) queue.add(ch);
        }
        while(!queue.isEmpty()){
            char ch = queue.poll();
            res += ch;
            if (map.containsKey(ch)){
                for (char next : map.get(ch)){
                    indegree.put(next, indegree.get(next) - 1);
                    if (indegree.get(next) == 0) queue.add(next);
                }
            }
        }
        if (res.length() != indegree.size()) return "";
        return res;       
    }
}





