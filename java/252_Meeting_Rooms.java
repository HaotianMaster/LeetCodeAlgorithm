class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        Comparator<Interval> mComparator = new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        };
        Arrays.sort(intervals, mComparator);
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i+1].start < intervals[i].end) return false;
        }
        return true;
    }
}