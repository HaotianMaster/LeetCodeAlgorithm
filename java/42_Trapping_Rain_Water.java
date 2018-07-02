// Approach #1 Brute force [Accepted] O(n^2) time and O(1) space.

class Solution {
    public int trap(int[] height) {
        int max = 0;
        int maxleft;
        int maxright;
        for (int i=1; i<height.length-1; i++) {
            maxleft = 0;
            maxright = 0;
            for (int j=i; j>=0; j--) {
                maxleft = Math.max(maxleft, height[j]);
            }
            for (int j=i; j<height.length; j++) {
                maxright = Math.max(maxright, height[j]);
            }
            max = max+Math.min(maxleft, maxright)-height[i];
        }
        return max;
    }
}

//Approach #2 Dynamic Programming [Accepted]  O(n) time and O(n) space.

class Solution {
    public int trap(int[] height) {
        int max = 0;
        if (height==null||height.length <= 1) {
            return max;
        }
        int[] maxleft = new int[height.length];
        int[] maxright = new int[height.length];
        maxleft[0] = height[0];
        maxright[height.length-1] = height[height.length-1];
        for (int i=1; i<height.length; i++) {
            maxleft[i] = Math.max(height[i], maxleft[i-1]);
        }
        for (int i=height.length-2; i>=0; i--) {
            maxright[i] = Math.max(height[i], maxright[i+1]);
        }
        for (int i=0; i<height.length; i++) {
            max = max+Math.min(maxleft[i], maxright[i])-height[i];
        }
        return max;
    }
}

// Approach #3 Using stacks [Accepted]  O(n) time and O(n) space.

class Solution {
    public int trap(int[] height) {
        if (height == null || height.length <= 1) return 0;
        int res = 0;
        int right = 0;
        Stack<Integer> st = new Stack<>();
        while (right < height.length) {
            if (st.isEmpty() || height[right] <= height[st.peek()]) {
                st.push(right++);
            }
            else {
                int bot = st.pop();
                if (!st.isEmpty()) {
                    int left = st.peek();
                    res += (right - left - 1) * (Math.min(height[left], height[right]) - height[bot]);                    
                }
            }
        }
        return res;
    }
}



// Approach #4 Using 2 pointers [Accepted] O(n) time and O(1) space.

class Solution {
    public int trap(int[] height) {
        if (height == null || height.length <= 1) return 0;
        int res = 0;
        int left = 0, right = height.length - 1;
        int leftmax = 0, rightmax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                leftmax = Math.max(leftmax, height[left]);
                res += leftmax - height[left++];
            }
            else {
                rightmax = Math.max(rightmax, height[right]);
                res += rightmax - height[right--];                
            }
        }
        return res;
    }
}
