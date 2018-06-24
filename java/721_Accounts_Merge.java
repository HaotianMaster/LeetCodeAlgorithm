class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Set<String>> graph = new HashMap<>(); // email, a set of neighbor email in the list
        Map<String, String> name = new HashMap<>(); // email, name
        // building graph
        for (List<String> account : accounts) {
            String userName = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                if (!graph.containsKey(account.get(i))) {
                    graph.put(account.get(i), new HashSet<>());
                }
                // Maybe one person has multiple names, but we only need to retain one name for one person.
                name.put(account.get(i), userName);
                if (i == 1) continue;
                graph.get(account.get(i)).add(account.get(i-1));
                graph.get(account.get(i-1)).add(account.get(i));
            }
        }
        Set<String> visited = new HashSet<>();
        List<List<String>> res = new ArrayList<>();
        for (String email : graph.keySet()) {
            if (visited.add(email)) {
                List<String> list = new ArrayList<>();
                dfs(graph, email, list, visited);
                Collections.sort(list);
                list.add(0, name.get(email));
                res.add(list);
            }
        }
        return res;
    }
    public void dfs(Map<String, Set<String>> graph, String email, List<String> list, Set<String> visited) {
        list.add(email);
        for (String next : graph.get(email)) {
            if (visited.add(next)) {
                dfs(graph, next, list, visited);
            }
        }
    }
}