// Graph + Topological sort. 
class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indegrees = new HashMap<>();
        for (List<Integer> seq : seqs) {
            if (seq.size() == 1) {
                if (!map.containsKey(seq.get(0))) {
                    map.put(seq.get(0), new HashSet<>());
                    indegrees.put(seq.get(0), 0);
                }
            }
            else {
                for (int i = 0; i < seq.size() - 1; i++) {
                    if (!map.containsKey(seq.get(i))) {
                        map.put(seq.get(i), new HashSet<>());
                        indegrees.put(seq.get(i), 0);
                    }
                    if (!map.containsKey(seq.get(i + 1))) {
                        map.put(seq.get(i + 1), new HashSet<>());
                        indegrees.put(seq.get(i + 1), 0);
                    } 
                    if (map.get(seq.get(i)).add(seq.get(i + 1))) {
                        indegrees.put(seq.get(i + 1), indegrees.get(seq.get(i + 1)) + 1);
                    }
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int key : indegrees.keySet()) {
            if (indegrees.get(key) == 0) queue.offer(key);
        }
        int index = 0;
        while (!queue.isEmpty()) {
            if (queue.size() > 1) return false;
            int curr = queue.poll();
            if (index == org.length || curr != org[index++]) return false;
            for (int next : map.get(curr)) {
                indegrees.put(next, indegrees.get(next) - 1);
                if (indegrees.get(next) == 0) queue.offer(next);
            }
        }
        return index == org.length && index == map.size();
    }
}