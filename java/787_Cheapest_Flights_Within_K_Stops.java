class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] graph = new int[n][n];
        for (int[] flight : flights) {
            graph[flight[0]][flight[1]] = flight[2];
        }
        
        Map<Integer, Integer> best = new HashMap<>();
        Comparator<int[]> mComparator = new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        };
        PriorityQueue<int[]> pq = new PriorityQueue<>(mComparator);
        // int[cost, k, source], initialize the start point
        // k is the current distance from start point
        // At the beginning, k = 0.
        pq.offer(new int[]{0, 0, src});
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0], k = curr[1], source = curr[2];
            if (k > K+1 || cost > best.getOrDefault(k * 1000 + source, Integer.MAX_VALUE))
                continue;
            if (source == dst)
                return cost;
            for (int destination = 0; destination < n; destination++) {
                if (graph[source][destination] > 0) {
                    int newcost = cost + graph[source][destination];
                    if (newcost < best.getOrDefault((k+1) * 1000 + destination, Integer.MAX_VALUE)) {
                        pq.offer(new int[]{newcost, k+1, destination});
                        best.put((k+1) * 1000 + destination, newcost);
                    }   
                }
            }
        }
        return -1;
    }
}