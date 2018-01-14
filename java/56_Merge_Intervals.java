/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
// Sorting  O(nlgn) time becuase of sorting. 
class Solution {
    private class compareIntervals implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new compareIntervals());
        LinkedList<Interval> merged = new LinkedList<>();
        for (Interval curr:intervals) {
            if (merged.isEmpty() || merged.getLast().end < curr.start) {
                merged.add(curr);
            }
            else {
                merged.getLast().end = Math.max(curr.end, merged.getLast().end);
            }
        }
        return merged;
    }
}
// Sorting also. 
class Solution {
    private class compareIntervals implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }
    public List<Interval> merge(List<Interval> intervals) {       
        List<Interval> merged = new ArrayList<>();
        if (intervals==null || intervals.size()==0) {
            return merged;
        }
        Collections.sort(intervals, new compareIntervals());
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (int i=0; i<intervals.size(); i++) {
            if (intervals.get(i).start<=end) {
                end = Math.max(end, intervals.get(i).end);
            }
            else {
                merged.add(new Interval(start, end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }
        }
        merged.add(new Interval(start, end));
        return merged;
    }
}

/**
 * However, if we don't want to sort the input list and do this in O(n) time, we need to think of some special data structure. 
 * By sorting, we actually want the interval in intervals list with the smallest start time
 * Minimum heap can just do this in armortized O(n) time. 
 * So we construct a minimum heap with all the intervals in armortized O(n) time and take out the one with the smallest start time in O(1) time 
 * and merge it with the current interval we are considering  until the minimum heap is empty. 
 * O(n) time, O(n) space where n is the size of the intervals list.
 */


class Solution {
    public List<Interval> merge(List<Interval> intervals) {       
        LinkedList<Interval> merged = new LinkedList<>();
        if (intervals==null || intervals.size()==0) {
            return merged;
        }
        // PriorityQueue(int initialCapacity, Comparator<? super E> comparator)
        PriorityQueue<Interval> minHeap = new PriorityQueue<>(intervals.size(), (i1, i2) -> {return i1.start - i2.start;});
        minHeap.addAll(intervals);
        while (!minHeap.isEmpty()) {
            Interval curr = minHeap.poll();
            if (merged.isEmpty() || merged.getLast().end<curr.start) {
                merged.add(curr);
            }
            else {
                merged.getLast().end = Math.max(merged.getLast().end, curr.end);
            }
        }
        return merged;
    }
}

class Solution {
    public List<Interval> merge(List<Interval> intervals) {       
        List<Interval> merged = new ArrayList<>();
        if (intervals==null || intervals.size()==0) {
            return merged;
        }
        // PriorityQueue(int initialCapacity, Comparator<? super E> comparator)
        Queue<Interval> minHeap = new PriorityQueue<>(intervals.size(), (i1, i2) -> {return i1.start - i2.start;});
        minHeap.addAll(intervals);      
        while (!minHeap.isEmpty()) {
            Interval curr = minHeap.poll();
            while (minHeap.peek()!=null && minHeap.peek().start<=curr.end) curr.end = Math.max(curr.end, minHeap.poll().end);
            merged.add(curr);
        }
        return merged;
    }
}   














