class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1, j=n-1, k=m+n-1;
        while (i>-1 && j>-1) {
            if (nums1[i]>=nums2[j]) {
                nums1[k--] = nums1[i--];                
            }
            else {
                nums1[k--] = nums2[j--]; 
            }
        }
        while (j>-1) nums1[k--] = nums2[j--];
    }
}

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1, j=n-1, k=m+n-1;
        while (i>-1 && j>-1) nums1[k--] = (nums1[i]>=nums2[j]) ? nums1[i--] : nums2[j--];      
        while (j>-1) nums1[k--] = nums2[j--];
    }
}

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m+n-1;
        int k1 = m-1;
        int k2 = n-1;
        while (k1 >= 0 && k2 >= 0) {
            if (nums1[k1]<=nums2[k2]) nums1[k--] = nums2[k2--];
            else nums1[k--] = nums1[k1--];
        }
        if (k1<0) {
            for (int i=k2; i>=0; i--) nums1[i] = nums2[i];
        }
        //while (k2>=0) nums1[k--] = nums2[k2--]; This is also good.
    }
}

