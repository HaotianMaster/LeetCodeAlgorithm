class WordDistance {
    String[] words;
    Map<String, List<Integer>> map;
    int res;
    public WordDistance(String[] words) {
        this.words = words;
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], new ArrayList<>());
            }
            map.get(words[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        res = Integer.MAX_VALUE;        
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int p1 = 0, p2 = 0;
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