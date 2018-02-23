// Heap.
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String word : words) {
            if (map.containsKey(word)) map.put(word, map.get(word)+1);
            else map.put(word, 1);
        }
        //Your answer should be sorted by frequency from highest to lowest. 
        //If two words have the same frequency, then the word with the lower alphabetical order comes first.
        Comparator<Map.Entry<String, Integer>> myComparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                if (e1.getValue() != e2.getValue()) return e2.getValue() - e1.getValue();
                else return e1.getKey().compareTo(e2.getKey());
            }
        };
        
        PriorityQueue<Map.Entry<String, Integer>> heap = new PriorityQueue<>(k, myComparator);
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            heap.add(entry);
        }
        
        for (int i=0; i<k; i++) {
            res.add(heap.poll().getKey());
        }
        
        return res;
    }
}
// Array.
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String word : words) {
            if (map.containsKey(word)) map.put(word, map.get(word)+1);
            else map.put(word, 1);
        }
        
        res = new ArrayList(map.keySet());
            
        Comparator<String> myComparator = new Comparator<String>() {
            @Override
            public int compare(String w1, String w2) {
                if (map.get(w1) != map.get(w2)) return map.get(w2) - map.get(w1);
                else return w1.compareTo(w2);
            }
        };
        
        Collections.sort(res, myComparator);
        
        return res.subList(0, k);
    }
}