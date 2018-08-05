// random guess
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        for (int i = 0; i < 10; i++) {
            String guess = wordlist[new Random().nextInt(wordlist.length)];
            int x = master.guess(guess);
            if (x == 6) break;
            List<String> wordlist2 = new ArrayList<>();
            for (String word : wordlist) {
                if (match(word, guess) == x) wordlist2.add(word);
            }
            wordlist = wordlist2.toArray(new String[wordlist2.size()]);
        }        
    }
    
    public int match(String a, String b) {
        int matches = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) matches++;
        }
        return matches;
    }
}


/** minimax
 * I said I could get accepted using random guess but not for sure. In fact it has 80% rate to get accepted.
 * Now we want to find a solution that improve this rate. We should guess a word that can minimum our worst case.
 * Generally, we will get 0 matches and wordlist size reduce slowly.
 * So we compare each two words and for each word, we note how many 0 matches it gets.
 * Then we guess the word with minimum 0 matches.
 * So even in most cases we get 0 match from master, it's still the best word that we can guess.
 * Because the wordlist will reduce at minimum as possible.
 */
class Solution { 
    public void findSecretWord(String[] wordlist, Master master) {
        for (int i = 0; i < 10; i++) {
            HashMap<String, Integer> count = new HashMap<>();
            for (String w1 : wordlist) {
                for (String w2 : wordlist) {
                    if (match(w1, w2) == 0) {
                        count.put(w1, count.getOrDefault(w1 , 0) + 1);
                    }
                }
            }
            String curr = "";
            int currCount = Integer.MAX_VALUE;
            for (String w : wordlist) {
                if (count.getOrDefault(w, 0) < currCount) {
                    curr = w;
                    currCount = count.getOrDefault(w, 0);
                }
            }
            int x = master.guess(curr);
            if (x == 6) break;
            List<String> wordlist2 = new ArrayList<String>();
            for (String w : wordlist) {
                if (match(curr, w) == x) {
                    wordlist2.add(w);
                }
            }
            wordlist = wordlist2.toArray(new String[wordlist2.size()]);
        }
    }
    
    public int match(String a, String b) {
        int matches = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) matches++;
        }
        return matches;
    }
}