// Using ourdegree and indegree to verify the traversal. 
class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int outdegree = 0;
        int indegree = 0; 
        for (String node : nodes) {
            if (outdegree - indegree < 0) return false;
            if (!node.equals("#")) {
                // non-leaf node
                indegree += 1;
                outdegree += 2;
            }
            else {
                // leaf node
                indegree += 1;
            }
        }
        // root do not has indegree, so --indegree
        return --indegree == outdegree;
    }
}

// Stack. 
public class Solution {
    public boolean isValidSerialization(String preorder) {
        // using a stack, scan left to right
        // case 1: we see a number, just push it to the stack
        // case 2: we see #, check if the top of stack is also #
        // if so, pop #, pop the number in a while loop, until top of stack is not #
        // if not, push it to stack
        // in the end, check if stack size is 1, and stack top is #
        if (preorder == null) return false;
        Stack<String> st = new Stack<>();
        String[] nodes = preorder.split(",");
        for (int i = 0; i < nodes.length; i++) {
            String curr = nodes[i];
            while (curr.equals("#") && !st.isEmpty() && st.peek().equals(curr)) {
                st.pop();
                if (st.isEmpty()) return false;
                st.pop();
            }
            st.push(curr);
        }
        return st.size() == 1 && st.peek().equals("#");
    }
}