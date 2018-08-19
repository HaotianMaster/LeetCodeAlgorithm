// Time complexity : O(n^2). The complete matrix of size n^2 is traversed.
// Space complexity : O(n). visitedvisited array of size n is used.
// DFS
class Solution {
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int res = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                dfs(M, visited, i);
                res++;
            }
        }
        return res;
    }
    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M[i].length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
}

// BFS
class Solution {
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int res = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                queue.add(i);
                while (!queue.isEmpty()) {
                    int s = queue.poll();
                    visited[s] = 1;
                    for (int j = 0; j < M.length; j++) {
                        if (M[s][j] == 1 && visited[j] == 0)
                            queue.add(j);
                    }
                }
                res++;
            }
        }
        return res;
    }
}

// Union Find
// Time complexity : O(n^3). We traverse over the complete matrix once. Union and find operations take O(n) time in the worst case.
// Space complexity : O(n). parent array of size nn is used.
class Solution {
    public int findCircleNum(int[][] M) {
        int[] parent = new int[M.length];
        Arrays.fill(parent, -1);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && i != j) {
                    union(parent, i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1)
                count++;
        }
        return count;
    }
    public int find(int parent[], int i) {
        if (parent[i] == -1) return i;
        return find(parent, parent[i]);
    }
    public void union(int parent[], int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        if (xset != yset)
            parent[xset] = yset;
    }
}









