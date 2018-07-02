// Sorting
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char task : tasks) {
            map[task - 'A']++;
        }
        // Task sequence does not matter.
        // We also don't care what task it is.
        // All we need is to iterate in descending order.
        // If we want to minimize the time, we have to make sure
        // the task with more frequency needed to be done as early as possible.
        Arrays.sort(map);
        int time = 0;
        while (map[25] > 0) {
            int i = 0;
            while (i <= n) {
                if (map[25] == 0) break;
                if (i < 26 && map[25 - i] > 0) {
                    map[25 - i]--;
                }
                time++;
                i++;
            }
            // re-sort to make sure we iterate in descending order all the time.
            Arrays.sort(map);
        }
        return time;
    }
}

// Very nice solution from Leetcode. 
// number of idle_slots + TotalNumberOfTasks
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char task : tasks) {
            map[task - 'A']++;
        }
        Arrays.sort(map);
        
        int time = 0;
        int numOfIdle = (map[25] - 1) * n;
        for (int i = 24; i >= 0 && map[i] > 0; i--) {
            numOfIdle -= Math.min(map[i], map[25] - 1);
        }
        
        return numOfIdle > 0 ? numOfIdle + tasks.length : tasks.length;
    }
}