// Approach #1 brute force 




// Approach #2 Using Extra Array [Accepted]
class Solution {
    public void rotate(int[] nums, int k) {
        int[] rotated = new int[nums.length];
	    k %= nums.length;
        for (int i = 0; i < nums.length; i++) {
            rotated[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rotated[i];
        }
    }
}

// An implementation that eaiser to come up with. Still Approach #2
class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int[] rotate = new int[nums.length];
        for (int i = 0; i < k; i++) {
            rotate[i] = nums[nums.length - k + i];
        }
        for (int i = 0; i < nums.length - k; i++) {
            rotate[i + k] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rotate[i];
        }
    }
}

/** Approach #3 Using Cyclic Replacements [Accepted] 
 * Since we want to rotate the array forward by k, we simply put every element forward by k, 
 * and do this for all nums.length = n elements. The tricky part of this algorithm is that 
 * it does not work if the array has a even length. In this case, we will always come back 
 * to the original position where we start the iteration in the array, a.k.a, we have a infinite 
 * loop. To solve this, we start the iteration again from the position followed by the previous 
 * one where we start the iteration once we reach it again. And we will get the final result 
 * after we perform count = nums.length = n movings, since each time we move one element to the 
 * right position and there is nums.length element in total.
 */
class Solution {
    public void rotate(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        k = k%n; 
        for (int i=0; count<n; i++) {
            int curr = i;
            int prevalue = nums[curr];
            do {
                int next = (curr+k)%n;
                int temp = nums[next];
                nums[next] = prevalue;
                curr = next;
                prevalue = temp;
                count++;
            } while (curr != i);
        }
    }
}

// Another implementaton of Approach #3.
class Solution {
    public void rotate(int[] nums, int k) {
        int init = 0;
        int curr = init;
        int count = 0;
        int n = nums.length;
        k = k%n;
        int prevalue = nums[curr]; 
        while (count < n) {  
            int next = (curr+k)%n; 
            int temp = nums[next]; 
            nums[next] = prevalue; 
            prevalue = temp;
            curr = next;  
            count++;
            if (count < n && curr == init) {
                init++;
                curr = init;
                prevalue = nums[curr];
            }         
        }
    }
}

/** Approach #4 Using Reverse [Accepted]
 *  Original List                   : 1 2 3 4 5 6 7
 *  After reversing all numbers     : 7 6 5 4 3 2 1
 *  After reversing first k numbers : 5 6 7 4 3 2 1
 *  After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result
 */
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
    private void reverse(int[] nums, int start, int end) {
        while (start<end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
