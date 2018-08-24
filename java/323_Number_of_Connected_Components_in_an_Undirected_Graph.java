// Union find
class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        int res = 0;
        for (int[] edge : edges) {
            int x = find(parent, edge[0]);
            int y = find(parent, edge[1]);
            if (x == y) continue;
            parent[x] = y;
        }
        for (int num : parent) {
            if (num == -1) res++;
        }
        return res;
    }
    public int find(int[] parent, int i) {
        if (parent[i] == -1) return i;
        return find(parent, parent[i]);
    }
}