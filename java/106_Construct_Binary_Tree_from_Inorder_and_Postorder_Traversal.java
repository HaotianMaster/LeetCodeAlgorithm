// The time complexity would be O(n/2 + n / 4 + n / 8 + ... + 1) = O(n) time on average considering the binary is approximately balance. Worst case O(n + n - 1 + n - 2 + ... + 1) = O(n^2) when the binary tree is like a linkedlist. 
// See here for proof: https://math.stackexchange.com/questions/401937/how-is-nn-2n-4-1-equal-to-2n-1-using-the-formula-for-geometric-series. 
// A small optimization to the time would be to add a HashMap store each number and its corresponding index of inorder array. Thus we shortens the time of looking up root position of each level to O(1), thus make the total time to be O(n) stably. But the space would be O(n) in this case. 
// See the second solution for an implementation.      
// The space complexity would be O(1) without the recursion stack. And O(logn) on average with the recursion stack. O(n) worst case. These conditions are the same with time. 
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) return null;
        return buildTreeHelper(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);        
    }
    
    public TreeNode buildTreeHelper(int[] inorder, int[] postorder, int post_end, int in_start, int in_end) {
        if (in_start > in_end)  return null;
        TreeNode curr = new TreeNode(postorder[post_end]);
        int i = in_start;
        while (i <= in_end) {
            if (inorder[i] == postorder[post_end]) break;
            i++;
        }
        curr.right = buildTreeHelper(inorder, postorder, post_end - 1, i + 1, in_end);
        curr.left = buildTreeHelper(inorder, postorder, post_end - (in_end - i + 1), in_start, i - 1);
        return curr;
    }
}

//Recursion implementation with HashMap.
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(inorder, postorder, postorder.length - 1, 0, inorder.length - 1, map);        
    }
    
    public TreeNode buildTreeHelper(int[] inorder, int[] postorder, int post_end, int in_start, int in_end, Map<Integer, Integer> map) {
        if (in_start > in_end)  return null;
        TreeNode curr = new TreeNode(postorder[post_end]);
        int i = map.get(postorder[post_end]);
        curr.right = buildTreeHelper(inorder, postorder, post_end - 1, i + 1, in_end, map);
        curr.left = buildTreeHelper(inorder, postorder, post_end - (in_end - i + 1), in_start, i - 1, map);
        return curr;
    }
    
}