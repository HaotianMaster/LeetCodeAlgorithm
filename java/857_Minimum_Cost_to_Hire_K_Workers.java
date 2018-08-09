class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        double[][] workers = new double[quality.length][2];
        for (int i = 0; i < quality.length; i++) {
            workers[i] = new double[] {(double) (wage[i]) / quality[i], (double) quality[i]};
        }
        Comparator<double[]> mComparator1 = new Comparator<double[]>(){
            @Override
            public int compare(double[] a, double[] b) {
                if (a[0] - b[0] < 0) return -1;
                if (a[0] - b[0] > 0) return 1;
                return 0;
            }
        };
        Arrays.sort(workers, mComparator1);

        Comparator<double[]> mComparator2 = new Comparator<double[]>(){
            @Override
            public int compare(double[] a, double[] b) {
                return (int)(b[1] - a[1]);
            }
        };
        double res = Double.MAX_VALUE, quality_sum = 0;
        PriorityQueue<double[]> pq = new PriorityQueue<>(K + 1, mComparator2);
        for (double[] worker : workers) {
            pq.offer(worker);
            quality_sum += worker[1];
            if (pq.size() == K + 1) {
                quality_sum -= pq.poll()[1];
            }
            if (pq.size() == K) {
                res = Math.min(res, quality_sum * worker[0]);
            }
        }
        return res;        
    }
}




