// Memory Limit Exceeded 
class ExamRoom {
    int[] seats;
    boolean empty;
    public ExamRoom(int N) {
        seats = new int[N];
        empty = true;
    }

    public int seat() {
        int res = 0, l = -1, pos = 0;
        boolean emptyAgain = true;
        int count = 0;
        for (int r = 0; r < seats.length; r++) {
            if (seats[r] == 1) {
                count++;
                empty = false;
                emptyAgain = false;
                if (l == -1) {
                    res = Math.max(res, r);
                    pos = 0;
                }      
                else {
                    if (res < (r - l) / 2) {
                        pos = (r - l) / 2 + l;
                        res = (r - l) / 2;
                    }
                }
                l = r;
            }
        }
        if (emptyAgain) empty = true;
        if (!empty && seats[seats.length - 1] == 0) {
            if (count == seats.length - 1 || res < seats.length - 1 - l) {
                pos = seats.length - 1;
            }          
        }
        seats[pos] = 1;
        return pos;
    }
 
    public void leave(int p) {
        seats[p] = 0;
    }
}