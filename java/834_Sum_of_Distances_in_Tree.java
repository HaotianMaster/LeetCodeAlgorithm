class Solution {
    int[] res, count;
    List<Set<Integer>> tree;
    int n;
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        //An array of hashset tree, tree[i] contains all connected nodes to i-th node
        tree = new ArrayList<>();
        //res[i] counts sum of distance in subtree i
        res = new int[N];
        //count[i] counts all nodes in the subtree i
        count = new int[N];
        n = N;
        
        for (int i = 0; i < N; i++) {
            tree.add(new HashSet<>());
        }
        
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        //calculate count and res[root]
        dfs1(0, new HashSet<>());
        //calculate remaining res[i]
        //When we move our root from parent to its child i, 
        //count[i] points get 1 closer to root, n - count[i] nodes get 1 futhur to root.
        dfs2(0, new HashSet<>());
        
        return res;
    }
    
    public void dfs1(int root, Set<Integer> visited) {
        visited.add(root);
        for (int neighbor : tree.get(root)) {
            if (!visited.contains(neighbor)) {
                dfs1(neighbor, visited);
                count[root] += count[neighbor];
                res[root] += res[neighbor] + count[neighbor];
            }
        }
        count[root]++;
    }
    
    public void dfs2(int root, Set<Integer> visited) {
        visited.add(root);
        for (int neighbor : tree.get(root)) {
            if (!visited.contains(neighbor)) {
                res[neighbor] = res[root] - count[neighbor] + n - count[neighbor];
                dfs2(neighbor, visited);
            }
        }
    }
}