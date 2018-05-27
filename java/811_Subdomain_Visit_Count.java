class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (String cpdomain : cpdomains) {
            String[] pair = cpdomain.split(" ");
            String[] domains = pair[1].split("\\.");
            int num = Integer.valueOf(pair[0]);
            String currDomain = "";
            for (int i = domains.length - 1; i >= 0; i--) {
                currDomain = domains[i] + currDomain;
                map.put(currDomain, map.getOrDefault(currDomain, 0) + num);
                currDomain = "." + currDomain;
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            res.add(entry.getValue() + " " + entry.getKey());
        }
        return res;
    }
}
