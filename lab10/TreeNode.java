package BSTwithWords;

public class TreeNode {
    //class variables

    Word word;
    TreeNode left;
    TreeNode right;

    // constructor
    // allows us to manually build a binary tree
    public TreeNode(Word word, TreeNode left, TreeNode right) {
        this.word = word;
        this.left = left;
        this.right = right;
    }

    // construct a TreeNode which doesn't have any child
    public TreeNode(Word word) {
        this.left = null;
        this.right = null;
        this.word = word;
    }
}
