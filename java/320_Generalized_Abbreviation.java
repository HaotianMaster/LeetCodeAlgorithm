public class Solution {
    public List<String> generateAbbreviations(String word){
        List<String> res = new ArrayList<String>();
        generateHelper(res, new StringBuilder(), word, 0, 0);
        return res;
    }
    public void generateHelper(List<String> res, StringBuilder sb, String word, int pos, int count) {
        int len = sb.length();
        if (pos == word.length()) {
            if (count != 0) sb.append(count);
            res.add(sb.toString());
        }
        else {
            // the branch that word.charAt(pos) is abbreviated
            generateHelper(res, sb, word, pos + 1, count + 1);

            // the branch that word.charAt(pos) is kept
            if (count != 0) sb.append(count);
            count = 0;
            sb.append(word.charAt(pos));
            generateHelper(res, sb, word, pos + 1, count);             
        }
        // reset builder to the original state
        sb.setLength(len); 
    }
}

public class Solution {
    public List<String> generateAbbreviations(String word){
        List<String> res = new ArrayList<String>();
        generateHelper(res, "", word, 0, 0);
        return res;
    }
    public void generateHelper(List<String> res, String curr, String word, int pos, int count) {
        if (pos == word.length()) {
            if (count != 0) curr = curr + String.valueOf(count);
            res.add(curr);
            return;
        }
        // the branch that word.charAt(pos) is abbreviated
        generateHelper(res, curr, word, pos + 1, count + 1);

        // the branch that word.charAt(pos) is kept
        if (count != 0) curr = curr + String.valueOf(count);
        count = 0;
        curr = curr + word.charAt(pos);
        generateHelper(res, curr, word, pos + 1, count);             
    }
}