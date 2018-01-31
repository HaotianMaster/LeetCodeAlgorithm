// HashMap
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> results = new ArrayList<>();
        if (strs == null || strs.length == 0) return results;
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i=0; i<strs.length; i++) {
            char[] curr = strs[i].toCharArray();
            Arrays.sort(curr);
            String currs = String.valueOf(curr);
            if (map.containsKey(currs)) {
                map.get(currs).add(strs[i]);
            }
            else {
                List<String> mlist = new ArrayList<>();
                mlist.add(strs[i]);
                map.put(currs, mlist);
            }
        }
        for (Map.Entry<String,List<String>> mEntry:map.entrySet()) {
            results.add(mEntry.getValue());
        }
        return results;
    }
}

// Still HashMap, but better implementation.

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> results = new ArrayList<>();
        if (strs == null || strs.length == 0) return results;
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i=0; i<strs.length; i++) {
            char[] curr = strs[i].toCharArray();
            Arrays.sort(curr);
            String currKey = String.valueOf(curr);
            if (!map.containsKey(currKey)) {
                map.put(currKey, new ArrayList<String>());
            }
            map.get(currKey).add(strs[i]);
        }
        return new ArrayList<List<String>>(map.values());
    }
}