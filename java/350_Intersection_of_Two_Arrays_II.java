//Two HashMap. O(n) time, O(n) space.
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[]{};
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int i=0; i<nums1.length; i++) {
            if (map1.containsKey(nums1[i])) map1.replace(nums1[i], map1.get(nums1[i])+1);
            else map1.put(nums1[i], 1);
        }
        for (int i=0; i<nums2.length; i++) {
            if (map2.containsKey(nums2[i])) map2.replace(nums2[i], map2.get(nums2[i])+1);
            else map2.put(nums2[i], 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int key1:map1.keySet()) {
            if (map2.containsKey(key1)) {
                int tempnum = Math.min(map1.get(key1), map2.get(key1));
                while (tempnum>0) {
                    list.add(key1);
                    tempnum--;
                }
            }
        }
        int[] intersection = new int[list.size()]; 
        for (int i=0; i<list.size(); i++) {
            intersection[i] = list.get(i);
        }
        return intersection;
    }
}

//Better HashMap. O(n) time, O(n) space.
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[]{};
        HashMap<Integer, Integer> map1 = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<nums1.length; i++) {
            if (map1.containsKey(nums1[i])) map1.replace(nums1[i], map1.get(nums1[i])+1);
            else map1.put(nums1[i], 1);
        }
        for (int i=0; i<nums2.length; i++) {
            if (map1.containsKey(nums2[i]) && map1.get(nums2[i]) > 0) {
                list.add(nums2[i]);
                map1.replace(nums2[i], map1.get(nums2[i])-1);
            }
        }
        int[] intersection = new int[list.size()]; 
        for (int ii=0; ii<list.size(); ii++) {
            intersection[ii] = list.get(ii);
        }
        return intersection;
    }
}

// What if the given array is already sorted? How would you optimize your algorithm?
// Two Pointers. O(nlogn) time, O(1) space.
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[]{};
        List<Integer> list = new ArrayList<>();
        int i = 0; int j = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            }
            else if (nums1[i] < nums2[j]) i++;
            else j++;
        }
        int[] intersection = new int[list.size()]; 
        for (int ii=0; ii<list.size(); ii++) {
            intersection[ii] = list.get(ii);
        }
        return intersection;
    }
}

// What if nums1's size is small compared to nums2's size? Which algorithm is better?

// What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

//1. (See the better HashMap solution) If only nums2 cannot fit in memory, put all elements of nums1 into a HashMap, read chunks of array that fit into the memory, and record the intersections.
//2. (See two pointers solution) If both nums1 and nums2 are so huge that neither fit into the memory, sort them individually (external sort), then read 2 elements from each array at a time in memory, record intersections.









