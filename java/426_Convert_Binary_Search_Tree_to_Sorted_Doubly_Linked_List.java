// Using a dummy node and do inorder traversal
class Solution {
    Node dummy = new Node(0, null, null);
    Node prev = dummy;
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        helper(root);
        // connect head and tail
        prev.right = dummy.right;
        dummy.right.left = prev;
        return dummy.right;
    }
    public void helper(Node curr) {
        if (curr == null) return;
        helper(curr.left);
        prev.right = curr;
        curr.left = prev;
        prev = curr;
        helper(curr.right);
    }
}

// We don't need dummy node.
// treeToDoublyList(root.left) return the head of the DoublyList formed by the left subtree
// treeToDoublyList(root.right) return the head of the DoublyList formed by the right subtree
class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;

        Node left = treeToDoublyList(root.left);
        Node head = root;
        if (left != null) {
            head = left;
            root.left = left.left;
            left.left.right = root;
        }
        Node right = treeToDoublyList(root.right);
        Node tail = root;
        if (right != null) {
            tail = right.left;
            root.right = right;
            right.left = root;
        }       

        head.left = tail;
        tail.right = head;
        return head;
    }
}

