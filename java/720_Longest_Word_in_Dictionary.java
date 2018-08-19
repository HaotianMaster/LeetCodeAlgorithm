// HashSet
class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> set = new HashSet<>();
        String res = "";
        for (String word : words) {
            if (word.length() == 1 || set.contains(word.substring(0, word.length() - 1))) {
                res = word.length() > res.length() ? word : res;
                set.add(word);
            }
        }
        return res;
    }
}

// Trie
class Solution {
    class TrieNode{
        char val;
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
        public TrieNode(char ch){
            val = ch;
        }
    }
    
    public String longestWord(String[] words) {
        TrieNode root = new TrieNode(' ');
        for(String word : words){
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (curr.children[ch - 'a'] == null) {
                    curr.children[ch - 'a'] = new TrieNode(ch); 
                }
                curr = curr.children[ch - 'a'];
            }
            curr.isWord = true;    
        }

        String res = dfs("", root);
        
        return res;
    }
    
    public String dfs(String str, TrieNode root) {  
        String res = "";
        for(int i = 0; i < 26; i++) {
            String curr = str;
            if (root.children[i] != null && root.children[i].isWord){
                curr += root.children[i].val;
                curr += dfs("", root.children[i]);
                if (curr.length() > res.length())
                    res = curr;
            }
        }
        return res;
    }
}