// HashMap
class MagicDictionary {
    Map<String, List<int[]>> map;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        map = new HashMap<>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String str : dict) {
            for (int i = 0; i < str.length(); i++) {
                String key = str.substring(0, i) + str.substring(i + 1);
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<int[]>());
                }
                List<int[]> list = map.get(key);
                list.add(new int[]{i, str.charAt(i)});
                map.put(key, list);
            }
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        for (int i = 0; i < word.length(); i++) {
            String key = word.substring(0, i) + word.substring(i + 1);
            if (map.containsKey(key)) {
                List<int[]> list = map.get(key);
                int[] pair = new int[]{i, word.charAt(i)};
                for (int[] curr : list) {
                    if (curr[0] == pair[0] && curr[1] != pair[1]) return true;
                }
            }
        }
        return false;
    }
}

class MagicDictionary {
    class TrieNode {
        char val;
        boolean isWord;
        TrieNode[] children = new TrieNode[26];
        public TrieNode(char ch) {
            val = ch;
        }
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new TrieNode(' ');
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String str : dict) {
            TrieNode curr = root;
            for (char ch : str.toCharArray()) {
                if (curr.children[ch - 'a'] == null) {
                    curr.children[ch - 'a'] = new TrieNode(ch);
                }
                curr = curr.children[ch - 'a'];
            }
            curr.isWord = true;
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        for (int i = 0; i < word.length(); i++) {
            char orgin = word.charAt(i);
            for (char ch = 'a'; ch < 'z'; ch++) {
                char[] wordArray = word.toCharArray();
                if (orgin != ch) {
                    wordArray[i] = ch;
                    if (helper(new String(wordArray), root)) return true;
                }
                wordArray[i] = orgin;
            }
        }
        return false;
    }
    
    public boolean helper(String word, TrieNode root) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            if (curr.children[ch - 'a'] == null) return false;
            curr = curr.children[ch - 'a'];
        }
        return curr.isWord;
    }
}
