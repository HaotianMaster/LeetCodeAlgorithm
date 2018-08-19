//DFS, my version of DFS is very slow.
class Solution {
    int curr = Integer.MAX_VALUE;
    public int[][] updateMatrix(int[][] matrix) {
        int[][] res = new int[matrix.length][matrix[0].length];
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                curr = Integer.MAX_VALUE;
                dfs(matrix, i, j, visited, 0);
                res[i][j] = curr;
            }
        }
        return res;
    }
    public void dfs(int[][] matrix, int i, int j, boolean[][] visited, int dist) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visited[i][j] == true) {
            return;
        } 
        if (matrix[i][j] == 0) {
            curr = Math.min(curr, dist);
            return;
        }
        if (curr > dist + 1) {
            visited[i][j] = true;
            dfs(matrix, i - 1, j, visited, dist + 1);
            dfs(matrix, i + 1, j, visited, dist + 1);
            dfs(matrix, i, j - 1, visited, dist + 1);
            dfs(matrix, i, j + 1, visited, dist + 1);
            visited[i][j] = false;      
        }
        return;
    }
}

//BFS
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int[][] res = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                res[i][j] = bfs(matrix, i, j, 0);
            }
        }
        return res;
    }
    public int bfs(int[][] matrix, int i, int j, int ) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});dist
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] coor = queue.poll();
                if (matrix[coor[0]][coor[1]] == 0) return dist;
                int[][] next = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
                for (int[] direction : next) {
                    int x = coor[0] + direction[0], y = coor[1] + direction[1];
                    if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length) {
                        queue.offer(new int[]{x, y});
                    }
                }
            }
            dist++;
        }
        return dist;
    }
}