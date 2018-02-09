// DFS
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0) return list;
        HashMap<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        letterHelper("", 0, digits, list, map);
        return list;
    }
    public void letterHelper(String curr, int currIdx, String digits, List<String> list, HashMap<Character, char[]> map) {
        if (currIdx == digits.length()) {
            list.add(curr);
            return;
        }
        char c = digits.charAt(currIdx);
        for (char ch:map.get(c)) {
            String next = curr+ch;
            letterHelper(next, currIdx+1, digits, list, map);
        }
    }
}

// BFS
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0) return list;
        HashMap<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        Deque<String> q = new ArrayDeque<>();
        q.add("");
        for (int currIdx=0; currIdx<digits.length(); currIdx++) {
            char c = digits.charAt(currIdx);
            while (q.peek().length() == currIdx) {
                String prev = q.poll();
                for (char ch:map.get(c)) {
                    q.add(prev+ch);
                }
            }
        }
        while(q.size() > 0) list.add(q.poll());
        return list;
    }
}


class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> list = new LinkedList<>();
        if (digits == null || digits.length() == 0) return list;
        HashMap<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        list.add("");
        for (int currIdx=0; currIdx<digits.length(); currIdx++) {
            char c = digits.charAt(currIdx);
            while (list.peek().length() == currIdx) {
                String prev = list.poll();
                for (char ch:map.get(c)) {
                    list.add(prev+ch);
                }
            }
        }
        return list;
    }
}