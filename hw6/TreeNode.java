package assignment6;

public class TreeNode {

    //fields
    Player player;
    TreeNode left;
    TreeNode right;
    int rCount;  //augment TreeNode data structure

    // constructor
    // allows us to manually build a binary tree
    public TreeNode(Player player, TreeNode left, TreeNode right) {
        this.player = player;
        this.left = left;
        this.right = right;
        this.rCount = 0;
    }

    // construct a TreeNode which doesn't have any child
    public TreeNode(Player player) {
        this.left = null;
        this.right = null;
        this.player= player;
        this.rCount = 0;
    }
}
