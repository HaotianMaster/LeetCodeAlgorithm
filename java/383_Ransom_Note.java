// HashMap. O(n) time, O(n) space.
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<magazine.length(); i++) {
            if (map.containsKey(magazine.charAt(i))) map.replace(magazine.charAt(i), map.get(magazine.charAt(i))+1);
            else map.put(magazine.charAt(i), 1);
        }
        for (int i=0; i<ransomNote.length(); i++) {
            if (map.containsKey(ransomNote.charAt(i)) && map.get(ransomNote.charAt(i))>0) {
                map.replace(ransomNote.charAt(i), map.get(ransomNote.charAt(i))-1);
            }
            else return false;
        }
        return true;       
    }
}

// Another solution. Still O(n) time, O(n) space. 
// O(1) space is impossible I think. 
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        for (int i=0; i<magazine.length(); i++) {
            count[magazine.charAt(i)-'a']++;
        }
        for (int i=0; i<ransomNote.length(); i++) {
            if (count[ransomNote.charAt(i)-'a'] == 0) {
                return false;
            }
            else count[ransomNote.charAt(i)-'a']--;
        }
        return true;       
    }
}