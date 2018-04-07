//Time complexity: O(n^2) time because heap.remove() takes O(n) time each.
//Space complexity: O(n) space.
//Scan and PriorityQueue
class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();
        //find all the start point and end point.
        for (int[] building : buildings) {
            heights.add(new int[]{building[0], -building[2]});
            heights.add(new int[]{building[1], building[2]});
        }
        Comparator<int[]> mComparator1 = new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0];
            }
        };
        //sort height in ascending position order, if a[0] == b[0], start point first.
        Collections.sort(heights, mComparator1);
        // Comparator<Integer> mComparator2 = new Comparator<Integer>(){
        //     @Override
        //     public int compare(int a, int b) {
        //         return b - a;
        //     }
        // };
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> (b - a));
        pq.offer(0);
        int prev = 0;
        for (int[] h : heights) {
            if (h[1] < 0) {
                pq.offer(-h[1]);
            }
            else {
                pq.remove(h[1]);
            }
            int curr = pq.peek();
            if (curr != prev) {
                res.add(new int[]{h[0], curr});
                prev = curr;
            }
        }
        return res;
    }
}

//TreeMap can optimize the time complexity.




