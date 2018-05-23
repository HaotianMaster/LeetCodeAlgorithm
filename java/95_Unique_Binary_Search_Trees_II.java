class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n <= 0) return res;
        res = generateTreesHelper(1, n);
        return res;
    }
    public List<TreeNode> generateTreesHelper(int start, int end) {
        List<TreeNode> ans = new ArrayList<>();
        if (start == end) {
            ans.add(new TreeNode(start));
            return ans;
        }
        for (int idx = start; idx <= end; idx++) {
            List<TreeNode> listOfLeft = generateTreesHelper(start, idx-1);
            List<TreeNode> listOfRight = generateTreesHelper(idx+1, end);
            if (listOfLeft.size() > 0 && listOfRight.size() > 0) {
                for (int i = 0; i < listOfLeft.size(); i++) {
                    for (int j = 0; j < listOfRight.size(); j++) {
                        TreeNode curr = new TreeNode(idx);
                        curr.left = listOfLeft.get(i);
                        curr.right = listOfRight.get(j);
                        ans.add(curr);
                    }
                }                
            }
            else if (listOfLeft.size() > 0) {
                for (int i = 0; i < listOfLeft.size(); i++) {
                    TreeNode curr = new TreeNode(idx);
                    curr.left = listOfLeft.get(i);
                    ans.add(curr);                      
                }              
            }
            else if (listOfRight.size() > 0){
                for (int i = 0; i < listOfRight.size(); i++) {
                    TreeNode curr = new TreeNode(idx);
                    curr.right = listOfRight.get(i);
                    ans.add(curr);                      
                }                
            }
        }
        return ans;
    }
}