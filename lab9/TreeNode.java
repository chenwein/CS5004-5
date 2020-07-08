package BST;

public class TreeNode {
    int val;

    // two pointers
    TreeNode left;
    TreeNode right;

    // constructor
    // allows us to manually build a binary tree
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // construct a TreeNode which doesn't have any child
    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
