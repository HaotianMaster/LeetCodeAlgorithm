class RandomizedCollection {
    List<Integer> list;
    Map<Integer, Set<Integer>> map;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = map.containsKey(val);
        if (!contain) {
            map.put(val, new HashSet<>());
        }
        map.get(val).add(list.size());
        list.add(val);
        return !contain;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int pos = map.get(val).iterator().next();
        map.get(val).remove(pos);
        if (pos < list.size() - 1) {
            int lastVal = list.get(list.size() - 1);
            list.set(pos, lastVal);
            map.get(lastVal).add(pos);
            map.get(lastVal).remove(list.size() - 1);
        }
        if (map.get(val).isEmpty()) map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        int random = new Random().nextInt(list.size());
        return list.get(random);
    }
}
