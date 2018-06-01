class RandomizedSet {
    List<Integer> list;
    //Mapping the num with its index in arraylist.
    Map<Integer, Integer> map;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int pos = map.get(val);
        //To preserve the mapping between the num and its index, swap the last one with this val in arraylist.
        if (pos < list.size() - 1) {
            int lastVal = list.get(list.size() - 1); 
            list.set(pos, lastVal);
            map.put(lastVal, pos);
        }
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int random = new Random().nextInt(list.size());
        return list.get(random);
    }
}