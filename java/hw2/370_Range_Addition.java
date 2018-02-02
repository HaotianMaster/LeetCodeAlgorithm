// Accepted Brute force. O(n*k) time, O(1) space.
class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] array = new int[length];
        for (int[] update:updates) {
            for(int i=update[0]; i<=update[1]; i++) {
                array[i] += update[2];
            }
        }
        return array;
    }
}
// O(n+k) time, O(1) space. A very smart solution. Range Caching.
class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] array = new int[length];
        for (int[] update:updates) {
            array[update[0]] += update[2]; // start sign 
            if (update[1]+1<length) array[update[1]+1] -= update[2]; // end sign 
        }
        for (int i=1; i<length; i++) {
            array[i] += array[i-1];
        }
        return array;
    }
}