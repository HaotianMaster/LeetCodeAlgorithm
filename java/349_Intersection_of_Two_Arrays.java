// Two sets. O(n) time, O(n) space solution. 
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i=0; i<nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i=0; i<nums2.length; i++) {
            set2.add(nums2[i]);
        }
        int count = 0;
        for (int curr:set2) {
            if (set1.contains(curr)) {
                nums1[count] = curr;
                count++;
            }
        }
        int[] intersection = new int[count];
        for (int i=0; i<count; i++) {
            intersection[i] = nums1[i];
        }
        return intersection;
    }
}
// Better two sets. O(n) time, O(n) space solution. 
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> intersec = new HashSet<>();
        for (int i=0; i<nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i=0; i<nums2.length; i++) {
            if (set1.contains(nums2[i])) intersec.add(nums2[i]);
        }
        int[] intersection = new int[intersec.size()];
        int count = 0;
        for (int curr:intersec) {
            intersection[count] = curr;
            count++;
        }
        return intersection;
    }
}

// Two pointers. O(nlogn) time, O(1) space solution. 
