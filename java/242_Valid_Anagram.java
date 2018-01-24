// Sorting
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        return Arrays.equals(s1, s2);
    }
}

//HashMap
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            if (map1.containsKey(s.charAt(i))) map1.replace(s.charAt(i), map1.get(s.charAt(i))+1);
            else map1.put(s.charAt(i), 1);
            if (map2.containsKey(t.charAt(i))) map2.replace(t.charAt(i), map2.get(t.charAt(i))+1);
            else map2.put(t.charAt(i), 1);
        }
        return map1.equals(map2);
    }
}