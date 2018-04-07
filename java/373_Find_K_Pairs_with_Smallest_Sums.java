// O(KlogK) time. 
class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0) return res;
        
        Comparator<int[]> mComparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] + a[1] - b[0] - b[1];
            }
        };
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, mComparator);
        for (int i = 0; i < nums1.length && i < k; i++) {
                pq.offer(new int[] {nums1[i], nums2[0], 0});
        }
        
        while (k-- > 0 && !pq.isEmpty()) {
            int[] curr = pq.poll();
            res.add(new int[] {curr[0], curr[1]});
            if (curr[2] + 1 == nums2.length) continue;
            pq.offer(new int[] {curr[0], nums2[curr[2] + 1], curr[2] + 1});
        }
        return res;
    }
}