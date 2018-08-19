// we want to add at least 2 copies.
class Solution {
    public int repeatedStringMatch(String A, String B) {
        String repeated_A = A;
        for (int rep = 1; rep <= B.length() / A.length() + 2; rep++, repeated_A += A)
            if (repeated_A.indexOf(B) != -1) return rep;
        return -1;        
    }
}