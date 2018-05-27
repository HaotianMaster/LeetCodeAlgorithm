class WordDictionary {
    public TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode(' ');
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
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
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(word, root, 0);    
    }
    
    public boolean match(String word, TrieNode curr, int index) {
        if (index == word.length()) return curr.isWord;
        char ch = word.charAt(index);
        if (ch == '.') {
            for (int i = 0; i < curr.children.length; i++) {
                if (curr.children[i] != null && match(word, curr.children[i], index + 1)) {
                    return true;
                }
            }
        }
        else if (curr.children[ch - 'a'] == null) return false;
        else return match(word, curr.children[ch - 'a'], index + 1);
        return false;
    }
}

class TrieNode {
    public char val;
    public boolean isWord;
    TrieNode[] children = new TrieNode[26];
    public TrieNode(char ch) {
        val = ch;
    }
}