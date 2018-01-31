// HashMap. The mapping is unique. 
class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (str == null || str.length() == 0) return true;

        String[] strs = str.split(" ");
        HashMap<Character, String> map = new HashMap<>();
        
        if (strs.length != pattern.length()) return false;
        
        for (int i=0; i<strs.length; i++) {
            if (!map.containsKey(pattern.charAt(i))) {
                if (map.containsValue(strs[i])) return false;
                map.put(pattern.charAt(i), strs[i]);
            }
            else {
                if (!map.get(pattern.charAt(i)).equals(strs[i])) return false;
            }
        }
        return true;
    }
}