class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
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
            if (!words1[i].equals(words2[i]) && (!map.containsKey(words1[i]) || !map.get(words1[i]).contains(words2[i]))) return false; 
        }
        
        return true;
    }
}