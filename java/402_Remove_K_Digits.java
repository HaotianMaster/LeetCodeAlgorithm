// Lots of corner cases need to be considered.
public class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() <= k) return "0";
        Deque<Character> deque = new ArrayDeque<>();
        //Greedy. Always remove the first peek.
        for (int i = 0; i < num.length(); i++) {
            while (!deque.isEmpty() && deque.peek() > num.charAt(i) && k > 0) {
                deque.poll();
                k--;
            }
            deque.push(num.charAt(i));
        }
        //In case of "12345", 2
        while (k > 0) {
            deque.poll();
            k--;
        }
        //In case of, "1022", 1
        while (!deque.isEmpty() && deque.peekLast() == '0') deque.pollLast();
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) sb.append(deque.pollLast());
        //In case of, "10", 1
        return sb.length() == 0 ? "0" : sb.toString();
    }
}