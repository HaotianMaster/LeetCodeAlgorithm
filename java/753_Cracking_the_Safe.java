//This is kinda greedy approach.
//So straight up we can tell that we have k^n combinations of the lock.
//So the best way to generate the string is reusing last n-1 digits of previous lock << I can't really prove this but I realized this after writing down some examples.

//Hence, we'll use dfs to generate the string with goal is when our string contains all possible combinations.
class Solution {
    public String crackSafe(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int total = (int) Math.pow(k, n);
        for (int i = 0; i < n; i++) {
            sb.append(0);
        }
        Set<String> visited = new HashSet<>();
        visited.add(sb.toString());
        dfs(sb, total, visited, n, k);
        return sb.toString();
    }
    public boolean dfs(StringBuilder sb, int total, Set<String> visited, int n, int k) {
        if (visited.size() == total) return true;
        String prev = sb.substring(sb.length() - n + 1, sb.length());
        for (int i = 0; i < k; i++) {
            String next = prev + i;
            if (!visited.contains(next)) {
                visited.add(next);
                sb.append(i);
                if (dfs(sb, total, visited, n, k)) return true;
                else {
                    visited.remove(next);
                    sb.delete(sb.length() - 1, sb.length());
                }
            }
        }
        return false;
    }
}