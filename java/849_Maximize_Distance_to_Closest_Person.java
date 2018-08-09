// Two pointers
class Solution {
    public int maxDistToClosest(int[] seats) {
        int res = 1;
        int l = -1;
        for (int r = 0; r < seats.length; r++) {
            if (seats[r] == 1) {
                //leading zeros
                if (l == -1) res = Math.max(res, r);
                else res = Math.max(res, (r - l) / 2); //middle
                l = r;
            }
        }
        //tailing zeros
        if (seats[seats.length - 1] == 0) {
            res = Math.max(res, seats.length - 1 - l);
        }
        return res;
    }
}

class ExamRoom {
    int N;
    ArrayList<Integer> L; //Use a list L to record the index of seats where people sit.
    public ExamRoom(int n) {
        N = n;
        L = new ArrayList<>();
    }

    public int seat() {
        if (L.size() == 0) {
            L.add(0);
            return 0;
        }
        //compare number of the leading zeros and tailing zeros
        int d = Math.max(L.get(0), N - 1 - L.get(L.size() - 1));
        //then compare with the middle maximum distance
        for (int i = 0; i < L.size() - 1; i++) d = Math.max(d, (L.get(i + 1) - L.get(i)) / 2);
        //If there are multiple such seats, they sit in the seat with the lowest number.
        if (L.get(0) == d) {
            L.add(0, 0);
            return 0;
        }
        for (int i = 0; i < L.size() - 1; i++)
            if ((L.get(i + 1) - L.get(i)) / 2 == d) {
                L.add(i + 1, (L.get(i + 1) + L.get(i)) / 2);
                return L.get(i + 1);
            }
        L.add(N - 1);
        return N - 1;
    }

    public void leave(int p) {
        for (int i = 0; i < L.size(); i++) if (L.get(i) == p) L.remove(i);
    }
}


class ExamRoom {
    TreeSet<Integer> s;
    int N;

    public ExamRoom(int N) {
        this.N = N;
        this.s = new TreeSet<>();
    }

    public int seat() {
    //When no student
        if (s.isEmpty()) {
            s.add(0);
            return 0;
        }
    //When One student
        if (s.size() == 1) {
            int num = s.first();
            if (num < (N / 2)) {
                s.add(N - 1);
                return N - 1;
            } 
            else {
                s.add(0);
                return 0;
            }
        }
    //When more than one student
        Iterator<Integer> it = s.iterator();
        int dist = -1;
        int position = -1;
        int left = it.next();
    //check the distance between 0 and first student
        if (left > 0) {
            position = 0;
            dist = left;
        }
        int right = -1;
    //Check the distance between adjacent indices,(already sorted)
        while (it.hasNext()) {
            right = it.next();
            if ((right - left) / 2 > dist) {
                dist = (right - left) / 2;
                position = left + dist;
            }
            left = right;
        }
    //check the distance between last student and (N - 1)
        if ((N - 1) - left > dist) {
            position = N - 1;
        }
        s.add(position);
        return position;
    }

    public void leave(int p) {
        s.remove(p);
    }
}

