//Each time of book, instead of fail a book when there is 1 or more overlap with existing books as in MyCalendar I, we just want to make sure these overlaps does not overlap
//having overlap is now ok, but overlapped period cannot be overlapped again.
//So we just need to keep track of all the overlaps with any previous books
class MyCalendarTwo {
    List<int[]> books;   
    public MyCalendarTwo() {
        books = new ArrayList<>(); 
    }
    
    public boolean book(int start, int end) {
        MyCalendar overlaps = new MyCalendar();
        for (int[] book : books) {
            if (Math.max(book[0], start) < Math.min(book[1], end)) // overlap exist
                if (!overlaps.book(Math.max(book[0], start), Math.min(book[1], end))) return false; // overlaps overlapped            
        }
        books.add(new int[]{start, end});
        return true;
    }

    private static class MyCalendar {
        List<int[]> books;
        public MyCalendar() {
            books = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            for (int[] book : books) {
                 if (Math.max(book[0], start) < Math.min(book[1], end)) return false;
            }
            books.add(new int[]{start, end});
            return true;
        }
    }
}