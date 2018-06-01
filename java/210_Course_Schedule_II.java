// BFS
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        int[] res = new int[numCourses];
        // Add set of all nodes with no incoming edge into queue.
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                res[count] = i;
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
                    res[count] = next;
                    count++;
                }
            }
        }
        
        return count == numCourses ? res : new int[]{};
    }
}

// DFS
class Solution {
    int count = 0;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, order, visited, visiting, i)) return new int[]{};
        }
        
        int[] res = new int[order.size()];
        for (int i = 0; i < order.size(); i++) {
            res[i] = order.get(i);
        }
        
        return res;
    }
    public boolean dfs(ArrayList[] graph, List<Integer> order, boolean[] visited, boolean[] visiting, int course) {
        if (visiting[course]) return false;
        visiting[course] = true;
        for (int i = 0; i < graph[course].size(); i++) {
            if (!visited[(int) graph[course].get(i)] && !dfs(graph, order, visited, visiting, (int) graph[course].get(i)))
                return false;
        }
        visiting[course] = false;
        if (!visited[course]) {
            visited[course] = true;
            order.add(0, course);            
        }
        return true;
    }
}