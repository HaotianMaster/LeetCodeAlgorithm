// HashMap. O(n) time, O(n) space.
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        if (s == null || s.length() <= 10) return list;       
        for (int i=0; i<=s.length()-10; i++) {
            if (map.containsKey(s.substring(i,i+10))) {
                map.replace(s.substring(i,i+10), map.get(s.substring(i,i+10))+1);
            }
            else {
                map.put(s.substring(i,i+10), 1);
            }
        }
        for (Map.Entry<String, Integer> curr:map.entrySet()) {
            if (curr.getValue()>1) list.add(curr.getKey());
        }
        return list;
    }
}

// 2 HashSet. O(n) time, O(n) space.
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();
        List<String> list = new ArrayList<>();
        if (s == null || s.length() <= 10) return list;       
        for (int i=0; i<=s.length()-10; i++) {
            if (!set1.add(s.substring(i, i+10))) {
                set2.add(s.substring(i, i+10));
            }
        }
        return new ArrayList<String>(set2);
    }
}
// 1 HashSet
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set1 = new HashSet<>();
        List<String> list = new ArrayList<>();
        if (s == null || s.length() <= 10) return list;       
        for (int i=0; i<=s.length()-10; i++) {
            if (!set1.add(s.substring(i, i+10)) && !list.contains(s.substring(i, i+10))) {
                list.add(s.substring(i, i+10));
            }
        }
        return list;
    }
}