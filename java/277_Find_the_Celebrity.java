/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        if (n < 2) return -1;
        int possible = 0;
        for (int i = 1; i < n; i++) {
            if (knows(possible, i)) {
                possible = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (possible != i && (!knows(i, possible) || knows(possible, i))) {
             return -1;   
            }
        }
        return possible;
    }
}