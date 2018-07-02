class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();      
        int left = 0, right = arr.length - 1;
        int pos = -1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= x) {
                right = mid;
            }
            else left = mid;
        }
        if (arr[left] >= x) pos = left;
        else if (arr[right] >= x) pos = right;
        else pos = right + 1;
        int i = pos - 1, j = pos;
        while (k > 0) {
            k--;
            if (i < 0 && j < arr.length) {
                res.add(arr[j]);
                j++;                   
            }
            else if (j >= arr.length && i >= 0) {
                res.add(0, arr[i]);
                i--;                
            }
            else if (Math.abs(arr[i] - x) <= Math.abs(arr[j] - x)) {
                res.add(0, arr[i]);
                i--;
            }
            else {
                res.add(arr[j]);
                j++;                
            }
        }
 
        return res;
    }
}