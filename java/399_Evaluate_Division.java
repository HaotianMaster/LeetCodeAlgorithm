// Convert to gragh and perform DFS
class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, List<String>> pairs = new HashMap<>();
        Map<String, List<Double>> valuesPair = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];
            if (!pairs.containsKey(equation[0])) {
                pairs.put(equation[0], new ArrayList<String>());
                valuesPair.put(equation[0], new ArrayList<Double>());
            }
            if (!pairs.containsKey(equation[1])) {
                pairs.put(equation[1], new ArrayList<String>());
                valuesPair.put(equation[1], new ArrayList<Double>());
            }
            pairs.get(equation[0]).add(equation[1]);
            pairs.get(equation[1]).add(equation[0]);
            valuesPair.get(equation[0]).add(values[i]);
            valuesPair.get(equation[1]).add(1/values[i]);
        }
        
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String src = queries[i][0], dst = queries[i][1];
            Set<String> visited = new HashSet<>();
            res[i] = dfs(src, dst, visited, pairs, valuesPair, 1.0);
            if (res[i] == 0.0) res[i] = -1.0;
        }
        return res;
    }
    public double dfs(String src, String dst, Set<String> visited, Map<String, List<String>> pairs, Map<String, List<Double>> valuesPair, double curr) {
        if (visited.contains(src)) return 0.0;
        if (!pairs.containsKey(src)) return 0.0;
        if (src.equals(dst)) return curr;
        visited.add(src);
        List<String> nextSrc = pairs.get(src);
        List<Double> nextValue = valuesPair.get(src);
        double ans = 0.0;
        for (int i = 0; i < nextSrc.size(); i++) {
            ans = dfs(nextSrc.get(i), dst, visited, pairs, valuesPair, curr * nextValue.get(i));
            if (ans != 0.0) break;
        }
        visited.remove(ans);
        return ans;
    }
}