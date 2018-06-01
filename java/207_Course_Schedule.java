// DFS, beat 16.50%, 106 ms.
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Representing a graph with adjacency lists.
        ArrayList[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }
        
        boolean[] visited = new boolean[numCourses];
        
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[1]].add(prerequisite[0]);
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visited, i)) return false;
        }
        
        return true;
    }
    public boolean dfs(ArrayList[] graph, boolean[] visited, int course) {
        if (visited[course]) return false;
        visited[course] = true;
        for (int i = 0; i < graph[course].size(); i++) {
            if (!dfs(graph, visited, (int) graph[course].get(i))) return false;
        }
        visited[course] = false;
        return true;
    }
}

// Optimized DFS, beat 99.94%, 8 ms.
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Representing a graph with adjacency lists
        ArrayList[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }
        
        boolean[] visited = new boolean[numCourses];
        boolean[] visiting = new boolean[numCourses];
        // Given a course, we want to know who depend on it for later BFS/DFS.
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[1]].add(prerequisite[0]);
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visited, visiting, i)) return false;
        }
        
        return true;
    }
    public boolean dfs(ArrayList[] graph, boolean[] visited, boolean[] visiting, int course) {
        if (visiting[course]) return false;
        visiting[course] = true;
        for (int i = 0; i < graph[course].size(); i++) {
            if (!visited[(int) graph[course].get(i)] && !dfs(graph, visited, visiting, (int) graph[course].get(i)))
                return false;
        }
        visiting[course] = false;
        visited[course] = true;
        return true;
    }
}

// BFS, beat 92.89%, 11 ms.
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Representing a graph with adjacency lists
        ArrayList[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int count=0;
        
        for (int[] prerequisite : prerequisites) {
            indegree[prerequisite[0]]++;
            graph[prerequisite[1]].add(prerequisite[0]);
        }
        
        // Add set of all nodes with no incoming edge into queue.
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                count++;
            }
        }
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int i = 0; i < graph[curr].size(); i++) {
                int next = (int) graph[curr].get(i);
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                    count++;
                }
            }
        }
        
        return count == numCourses ? true : false;
    }
}
