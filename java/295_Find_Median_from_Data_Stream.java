class MedianFinder {
    public PriorityQueue<Long> small;
    public PriorityQueue<Long> large;
    /** initialize your data structure here. */
    public MedianFinder() {
        small = new PriorityQueue<>();
        large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        large.add((long)num);
        small.add(-large.poll());
        if (large.size() < small.size()) {
            large.add(-small.poll());
        }
    }
    
    public double findMedian() {
        int size = large.size() + small.size();
        if (size % 2 == 0) {
            return (double)(large.peek() - small.peek()) / 2;
        }
        else {
            return large.peek();
        }
    }
}