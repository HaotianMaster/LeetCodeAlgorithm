// Hashset to keep track of visited numbers.
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n != 1){
            int sum = 0;
            n = next(n);
            if(!set.add(n)) return false;
        }
        return true;
    }
    
    public int next(int n) {
        int x = n, s = 0;
        while (x > 0) {
            s += Math.pow(x % 10, 2);
            x /= 10;
        }
        return s;
    }     
}

// Better method and O(1) space!
// Convert a HashTable problem into a detecting cycled link list problem.
class Solution {
    public boolean isHappy(int n) {
        int x = n, y = n;
        while (x > 1) {
            x = next(x);
            if (x == 1) return true;
            y = next(next(y));
            if (y == 1) return true;
            if (x == y) return false;
        }
        return true;
    }
    public int next(int n) {
        int x = n, s = 0;
        while (x > 0) {
            s += Math.pow(x % 10, 2);
            x /= 10;
        }
        return s;
    }
}