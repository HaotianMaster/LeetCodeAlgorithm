// Time Limit Exceeded
class MyCalendar {
    Set<Integer> set;
    public MyCalendar() {
        set = new HashSet<>();
    }
    
    public boolean book(int start, int end) {
        for (int i = start; i < end; i++) {
            if (!set.add(i)) {
                for (int j = start; j < i; j++) set.remove(j);
                return false;
            }
        }
        return true;
    }
}

// Sorted Map
class MyCalendar {
    TreeMap<Integer, Integer> treemap;
    public MyCalendar() {
        treemap = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer floorKey = treemap.floorKey(start);
        if (floorKey != null && treemap.get(floorKey) > start) return false;
        Integer ceilingKey = treemap.ceilingKey(start);
        if (ceilingKey != null && ceilingKey < end) return false;
        treemap.put(start, end);
        return true;
    }
}

// List
/*
 * case 1: b ends before a ends:
 * a: a0 |-------------| a1
 * b:     b0 |-----| b1
 *
 * case 2: b ends after a ends:
 * a: a0 |--------| a1
 * b:     b0 |--------| b1
 * 
 * case 3: b starts after a ends: (negative overlap)
 * a: a0 |----| a1
 * b:              b0 |----| b1
 */
class MyCalendar {
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





