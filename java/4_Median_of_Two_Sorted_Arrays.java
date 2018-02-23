//Brute force. Merge two sorted array and find median. 
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1 == null || nums1.length == 0) && (nums2 == null || nums2.length == 0)) return 0.0;
        if (nums1 == null) {
            double res = 0.0;
            int length = nums2.length; 
            if (length % 2 != 0) {
                res = nums2[length/2];
            }
            else {
                res = ((double)(nums2[(length-1)/2]+nums2[length/2]))/2;
            }
            return res;            
        }
        if (nums2 == null) {
            double res = 0.0;
            int length = nums1.length; 
            if (length % 2 != 0) {
                res = nums1[length/2];
            }
            else {
                res = ((double)(nums1[(length-1)/2]+nums1[length/2]))/2;
            }
            return res;            
        }
        int[] nums3 = new int[nums1.length+nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                nums3[k] = nums1[i];
                i++;
            }
            else {
                nums3[k] = nums2[j];
                j++;
            }
            k++;
        }
        if (i == nums1.length) {
            while (j < nums2.length) {
                nums3[k] = nums2[j];
                j++;
                k++;
            }
        }
        else{
             while (i < nums1.length) {
                nums3[k] = nums1[i];
                i++;
                k++;
            }           
        }
        double res = 0.0;
        int length = nums3.length; 
        if (length % 2 != 0) {
            res = nums3[length/2];
        }
        else {
            res = ((double)(nums3[(length-1)/2]+nums3[length/2]))/2;
        }
        return res;
    }
}