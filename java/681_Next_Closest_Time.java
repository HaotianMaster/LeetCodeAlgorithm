// DFS
class Solution {
    int diff_max = Integer.MAX_VALUE;
    String res = "";
    public String nextClosestTime(String time) {
        Set<Integer> set = new HashSet<>();
        set.add(Integer.valueOf(time.substring(0, 1)));
        set.add(Integer.valueOf(time.substring(1, 2)));
        set.add(Integer.valueOf(time.substring(3, 4)));
        set.add(Integer.valueOf(time.substring(4, 5)));
        if (set.size() == 1) return time;
        List<Integer> digits = new ArrayList<>(set);
        int minutes = Integer.valueOf(time.substring(0, 2)) * 60 + Integer.valueOf(time.substring(3, 5));
        dfs(minutes, digits, "", 0);
        return res;
    }
    public void dfs(int minutes, List<Integer> digits, String curr, int pos) {
        if (pos == 4) {
            int curr_time = Integer.valueOf(curr.substring(0, 2)) * 60 + Integer.valueOf(curr.substring(2, 4));
            if (curr_time == minutes) return;
            int diff = curr_time > minutes ? curr_time - minutes : 60 * 24 + curr_time - minutes;
            if (diff < diff_max) {
                diff_max = diff;
                res = curr.substring(0, 2) + ":" + curr.substring(2, 4);
            }
            return;
        }
        for (int digit : digits) {
            if (pos == 0 && digit > 2) continue;
            if (pos == 1 && Integer.valueOf(curr) * 10 + digit > 23) continue;
            if (pos == 2 && digit > 5) continue;
            if (pos == 3 && Integer.valueOf(curr.substring(2)) * 10 + digit > 59) continue;
            dfs(minutes, digits, curr + digit, pos + 1);
        }
    }
}

