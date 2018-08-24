//O(N^2)
//(1) The loop iterates over (n - 1) edges and calls find 2 times 
//(2) Find takes about O(N) if you don't optimize it with rank and path compression.
//So time complexity ~ O(N^2), space complexity is about O(N)(parent takes O(N)).
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        // initialize n isolated islands
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        
        // perform union find
        for (int i = 0; i < edges.length; i++) {
            int x = find(parent, edges[i][0]);
            int y = find(parent, edges[i][1]);
            
            // if two vertices happen to be in the same set
            // then there's a cycle
            if (x == y) return false;
            
            // union
            parent[y] = x;
        }
        
        return edges.length == n - 1;
    }
    
    public int find(int[] parent, int i) {
        if (parent[i] == -1) return i;
        return find(parent, parent[i]);
    }
}


// DFS
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        // initialize adjacency list
        ArrayList[] graph = new ArrayList[n];
        
        // initialize vertices
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList();
        }
           
        // add edges    
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        boolean[] visiting = new boolean[n];
        
        // make sure there's no cycle
        if (!noCycle(graph, visited, visiting, 0, -1))
            return false;
        
        // make sure all vertices are connected
        for (int i = 0; i < n; i++) {
            if (!visited[i]) 
                return false;
        }
        return true;
    }
    
    // check if an undirected graph has cycle started from vertex u
    public boolean noCycle(ArrayList[] graph, boolean[] visited, boolean[] visiting, int node, int parent) {
        if (visiting[node]) return false;
        visiting[node] = true;
        
        for (int i = 0; i < graph[node].size(); i++) {
            if ((int) graph[node].get(i) != parent && !visited[(int) graph[node].get(i)] && !noCycle(graph, visited, visiting, (int) graph[node].get(i), node))
                return false;
        }
        
        visited[node] = true;
        visiting[node] = false;
        return true;
    }
}


// BFS
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        // build the graph using adjacent list
        List<Set<Integer>> graph = new ArrayList<Set<Integer>>();
        for(int i = 0; i < n; i++)
            graph.add(new HashSet<Integer>());
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        // no cycle
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (visited[node]) return false;
            visited[node] = true;
            for (int neighbor : graph.get(node)) {
                queue.offer(neighbor);
                graph.get(neighbor).remove(node);
            }
        }
        
        // fully connected
        for (boolean result : visited) {
            if (!result)
                return false;
        }
        
        return true;
    }  
}
