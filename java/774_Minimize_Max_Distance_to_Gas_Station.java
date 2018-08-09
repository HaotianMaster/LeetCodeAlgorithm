class Solution {
    public double minmaxGasDist(int[] stations, int K) {
        int count, N = stations.length;
        //Initilze left = 0 and right = the distance between the first and the last station
        //[left, right] is the range of possible distance
        double left = 0, right = stations[N - 1] - stations[0], mid;
        //When left + 1e-6 >= right, it means the answer within 10^-6 of the true value and it will be accepted.
        while (left + 1e-6 < right) {
            mid = left + (right - left) / 2;
            count = 0;
            for (int i = 0; i < N - 1; ++i) {
                count += Math.ceil((stations[i + 1] - stations[i]) / mid) - 1;
            }
            if (count > K) left = mid;
            else right = mid;
        }
        return right;        
    }
}

class Solution {
    public double minmaxGasDist(int[] stations, int K) {
        double left = 0, right = stations[stations.length - 1] - stations[0];
        while (left + 1e-6 < right) {
            double mid = left + (right - left) / 2;
            int count = 0;
            for (int i = 0; i < stations.length - 1; i++) {
                count += (int)((stations[i + 1] - stations[i]) / mid);
            }
            if (count > K) left = mid;
            else right = mid;
        }
        return right;
    }
}