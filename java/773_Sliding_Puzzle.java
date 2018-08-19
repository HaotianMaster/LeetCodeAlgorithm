class Solution {
    public int slidingPuzzle(int[][] board) {
        Set<String> seen = new HashSet<>(); // used to avoid duplicates
        String target = "123450";
        // convert board to string - initial state.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]);
            }
        }
        String s = sb.toString();
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);  // add initial state to queue.
        seen.add(s); // add initial state to set.
        int res = 0; // record the # of rounds of Breadth Search
        while (!queue.isEmpty()) { // Not traverse all states yet?
            // loop used to control search breadth.
            int size = queue.size();
            for (int idx = 0; idx < size; idx++) { 
                String curr = queue.poll();
                if (curr.equals(target)) return res; // found target.
                int i = curr.indexOf('0'); // locate '0'
                int[] d = new int[]{1, -1, 3, -3}; // potential swap displacements.
                for (int k = 0; k < 4; k++) { // traverse all options.
                    int j = i + d[k]; // potential swap index.
                    // Conditional used to avoid invalid swaps.
                    // Note that, charAt(2) and charAt(3) are not adjacent in original 2 dimensional int array 
                    // and therefore are not valid swaps.
                    if (j < 0 || j > 5 || i == 2 && j == 3 || i == 3 && j == 2) continue; 
                    char[] ch = curr.toCharArray();
                    // swap ch[i] and ch[j].
                    char tmp = ch[i];
                    ch[i] = ch[j];
                    ch[j] = tmp;
                    s = String.valueOf(ch); // a new candidate state.
                    if (seen.add(s)) queue.offer(s);  //Avoid duplicate.
                }
            }
            res++; // finished a round of Breadth Search, plus 1.
        }
        return -1;        
    }
}
