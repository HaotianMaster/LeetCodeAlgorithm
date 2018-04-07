class Solution {
    public String frequencySort(String s) {
        if (s == null) return null;
        char[] characters = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : characters) {
            if (map.containsKey(ch)) map.put(ch, map.get(ch) + 1);
            else map.put(ch, 1);
        }
        Comparator<Map.Entry<Character, Integer>> mComparator = new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2) {
                return e2.getValue() - e1.getValue();
            }
        };
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(mComparator);
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }
        int size = pq.size();
        StringBuilder sb = new StringBuilder();
        while (size-- > 0) {
            Map.Entry<Character, Integer> curr = pq.poll();
            Character ch = curr.getKey();
            for (int i = 0; i < curr.getValue(); i++) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}