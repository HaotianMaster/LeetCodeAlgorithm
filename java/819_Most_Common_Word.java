class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            //remove any non-alphebatic characters from the word
            word = word.replaceAll("[^a-z]", "");
            //count the number of each word.
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        Set<String> set = new HashSet<>();
        for (String word : banned) {
            set.add(word);
        }
        String res = "";
        int max = 0;
        for (String word : map.keySet()) {
            if (!set.contains(word) && (max == 0 || map.get(word) > max)) {
                res = word;
                max = map.get(word);
            }
        }
        return res;
    }
}