// Heap
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        Comparator<Interval> mComparator = new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        };
        Arrays.sort(intervals, mComparator);
        int count = 0;
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < intervals.length; i++) {
            if (minHeap.isEmpty() || intervals[i].start < minHeap.peek()) {
                count++;
                minHeap.add(intervals[i].end);
            } else {
                minHeap.poll();
                minHeap.add(intervals[i].end);
            }
        }
        return count;
    }
}

//beat 100%, same underlying concept with heap method.
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int count = 0;
        int endpoint = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (start[i] < end[endpoint]) {
                count++;
            }
            else {
                endpoint++;
            }
        }
        return count;
    }
}