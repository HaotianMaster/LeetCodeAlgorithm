// HashMap. O(n) time, O(n) space. 
class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            if (map.containsKey(s.charAt(i))) map.replace(s.charAt(i), map.get(s.charAt(i))+1);
            else map.put(s.charAt(i), 1);
        }
        boolean hasOdd = false;
        for (Map.Entry<Character, Integer> entry:map.entrySet()) {
            if (hasOdd == true && entry.getValue()%2 != 0) return false;
            if (entry.getValue()%2 != 0) hasOdd = true;
        }
        return true;
    }
}
//Instead of making use of the inbuilt Hashmap, 
//we can make use of an array as a hashmap. 
//For this, we make use of an array mapmap with length 128. 
//Each index of this mapmap corresponds to one of the 128 ASCII characters possible.
class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        int[] map = new int[128];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
        }
        int count = 0;
        for (int i=0; i<128 && count<=1; i++) {
            count += map[i]%2;
        }
        return count <= 1;
    }
}