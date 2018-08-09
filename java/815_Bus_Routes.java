class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) return 0; 
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();     
        for(int i = 0; i < routes.length; i++){
            for(int j = 0; j < routes[i].length; j++){
                if (!map.containsKey(routes[i][j])) {
                    map.put(routes[i][j], new ArrayList<>());
                }
                map.get(routes[i][j]).add(i);               
            }       
        }
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(S);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            for (int i = 0; i < size; i++) {
                int curr_stop = queue.poll();
                ArrayList<Integer> buses = map.get(curr_stop);
                for (int bus : buses) {
                    if (!visited.contains(bus)) {
                        visited.add(bus);
                        for (int j = 0; j < routes[bus].length; j++) {
                            if (routes[bus][j] == T) return res;
                            queue.add(routes[bus][j]);                              
                        }
                    }
                }
            }
        }
        
        return -1;
    }
}