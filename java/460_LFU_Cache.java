// TreeMap
// Time complexity: O(logn) for both put and get where n is the size of the capacity.
// Space complexity: O(n).
class LFUCache {
    HashMap<Integer, CacheTuple> cache;
    TreeMap<CacheTuple, Integer> freqMap;
    int stamp;
    int capacity;
    
    class CacheTuple implements Comparable<CacheTuple> {
        int frequency;
        int value;
        int stamp;
        
        public CacheTuple(int frequency, int value, int stamp) {
            this.frequency = frequency;
            this.value = value;
            this.stamp = stamp;
        }
        
        public int compareTo(CacheTuple that) {
            if (this.frequency == that.frequency) {
                return this.stamp - that.stamp;
            }
            return this.frequency - that.frequency;
        }
    }

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.freqMap = new TreeMap<>();
        this.stamp = 0;
    }
    
    public int get(int key) {
        if (capacity <= 0) {
            return -1;
        }
        if (!cache.containsKey(key)) {
            return -1;
        }
        CacheTuple tuple = cache.get(key);
        CacheTuple newTuple = new CacheTuple(tuple.frequency + 1, tuple.value, ++stamp);
        freqMap.remove(tuple);
        cache.put(key, newTuple);
        freqMap.put(newTuple, key);
        return tuple.value;
    }
    
    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        if (cache.containsKey(key)) {
            CacheTuple tuple = cache.get(key);
            CacheTuple newTuple = new CacheTuple(tuple.frequency + 1, value, ++stamp);
            freqMap.remove(tuple);
            cache.put(key, newTuple);
            freqMap.put(newTuple, key);
        } 
        else {
            if (freqMap.size() >= capacity) {
                int oldKey = freqMap.pollFirstEntry().getValue();
                cache.remove(oldKey);
            }
            CacheTuple newTuple = new CacheTuple(1, value, ++stamp);
            cache.put(key, newTuple);
            freqMap.put(newTuple, key);
        }
    }
}

// PriorityQueue, same performance and coding logic with TreeMap.
class LFUCache {
    HashMap<Integer, CacheTuple> cache;
    PriorityQueue<CacheTuple> pq;
    int stamp;
    int capacity;
    
    class CacheTuple implements Comparable<CacheTuple> {
        int frequency;
        int value;
        int stamp;
        int key;
        public CacheTuple(int frequency, int value, int stamp, int key) {
            this.frequency = frequency;
            this.value = value;
            this.stamp = stamp;
            this.key = key;
        }
        
        public int compareTo(CacheTuple that) {
            if (this.frequency == that.frequency) {
                return this.stamp - that.stamp;
            }
            return this.frequency - that.frequency;
        }
    }

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.pq = new PriorityQueue<>();
        this.stamp = 0;
    }
    
    public int get(int key) {
        if (capacity <= 0) {
            return -1;
        }
        if (!cache.containsKey(key)) {
            return -1;
        }
        CacheTuple tuple = cache.get(key);
        CacheTuple newTuple = new CacheTuple(tuple.frequency + 1, tuple.value, ++stamp, key);
        pq.remove(tuple);
        cache.put(key, newTuple);
        pq.offer(newTuple);
        return tuple.value;
    }
    
    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        if (cache.containsKey(key)) {
            CacheTuple tuple = cache.get(key);
            CacheTuple newTuple = new CacheTuple(tuple.frequency + 1, value, ++stamp, key);
            pq.remove(tuple);
            cache.put(key, newTuple);
            pq.offer(newTuple);
        } 
        else {
            if (pq.size() >= capacity) {
                int oldKey = pq.poll().key;
                cache.remove(oldKey);
            }
            CacheTuple newTuple = new CacheTuple(1, value, ++stamp, key);
            cache.put(key, newTuple);
            pq.offer(newTuple);
        }
    }
}






/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */