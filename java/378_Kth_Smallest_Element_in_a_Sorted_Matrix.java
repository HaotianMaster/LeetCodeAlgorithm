// Heap
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return Integer.MIN_VALUE;
        int row = matrix.length;
        int col = matrix[0].length;
        int count = 0;
        int[] curr = null;
        Comparator<int[]> mComparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                return arr1[2] - arr2[2];
            }            
        };
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(k, mComparator);
        
        for (int i = 0; i < row; i++) {
            //Store [row, col, value] into heap
            //At the beginning, we store the first column
            minHeap.offer(new int[]{i, 0, matrix[i][0]});
        }
        
        while (count < k) {
            curr = minHeap.poll();
            int x = curr[0], y = curr[1];
            if (y + 1 < col) {
                minHeap.offer(new int[]{x, y + 1, matrix[x][y + 1]});
            }
            count++;
        }
        return curr[2];
    }
}

//Binary Search, beat 100%.  Instead of searching index, we search values. 
//First, we get the mid of the value scope, 
//then count for the number of elements that is less than or equal to it.
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        int start = matrix[0][0];
        int end = matrix[row][col]; 
        while (start < end) {
            int mid = start + (end - start) / 2;
            int count = noLargerThan(matrix, mid);
            if (count < k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }       
        return start;
    }
    private int noLargerThan(int[][] matrix, int mid) {
        //get the count of the elements not larger than mid value
        int count = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0;
        int j = col - 1;
        while (i < row && j >= 0) {
            if (matrix[i][j] > mid) {
                j--; //move to left column
            } else {
                count += j + 1; //All items on the left side of current row is added
                i++;
            }
        }       
        return count;
    }
}