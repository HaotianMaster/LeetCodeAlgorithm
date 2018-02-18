class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            if (map.containsKey(s.charAt(i))) map.replace(s.charAt(i), map.get(s.charAt(i))+1);
            else map.put(s.charAt(i), 1);
        }
        int count = 0;
        for (Map.Entry<Character, Integer> entry:map.entrySet()) {
            count += entry.getValue()%2;
            if (count > 1) return res;            
        }
        
        char[] st = new char[s.length()/2];
        int k = 0;
        String mid = "";
        for (Map.Entry<Character, Integer> entry:map.entrySet()) {
             char key = entry.getKey();
             int val = entry.getValue();
             if (val%2 == 1) mid += key;
             for (int i=0; i<val/2; i++) {
                 st[k++] = key;
             }
        }            
        
        generateHelper(st, "", res, mid, new boolean[st.length]);
        return res;
    }
    public void generateHelper(char[] st, String curr, List<String> res, String mid, boolean[] used) {
        if (curr.length() == st.length) {
            StringBuilder sb = new StringBuilder(curr);
            res.add(curr+mid+sb.reverse().toString()); 
            return;
        }
        char prev = '\0';
        for (int i=0; i<st.length; i++) {
            if (used[i] == false && st[i] != prev) {
                prev = st[i];
                used[i] = true;
                generateHelper(st, curr+st[i], res, mid, used);
                used[i] = false;
            }
        }
    }
}