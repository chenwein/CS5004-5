package assignment6;

import java.util.ArrayList;
import java.util.List;

public class BSTbyScore {
    TreeNode root;

    //constructors

    //with root
    public BSTbyScore(TreeNode root ) {
        this.root = root;
    }

    //default no argument constructor
    public BSTbyScore() {
        this.root = null;
    }

    public BSTbyScore(List<Player> list) {
        for (int i = 0; i < list.size(); i ++) {
            this.insert(list.get(i));
        }
    }

    /**
     * method takes a new player object and builds a binary search tree based on score
     * @param newPlayer object
     */
    public void insert(Player newPlayer) {
        if (this.root == null) {
            //if there is currently no root for this tree, insert it as the root
            //Create the node
            //assign newWord to newly created node
            TreeNode newRoot = new TreeNode(newPlayer);
            //assign it to this.root
            this.root= newRoot;
            return;
        }
        //else if there is already a root, recursively add the new player
        insertHelper(this.root,newPlayer);
    }

    private TreeNode insertHelper(TreeNode root, Player newPlayer) {
        //base case, the current node is null, set the node with newPlayer object
        if (root == null) {
            return new TreeNode(newPlayer);
        }

        //if node.player.score > root.player.score - go right
        //if node.player.score < root.player.score - go left
        //comparing with int, can use regular operators
        //assuming player ID is unique, no ambiguity, no else
        if (newPlayer.score > root.player.score) {
            root.right = insertHelper(root.right, newPlayer);
            //augment Tree, if inserted to the right, root.rCount increments
            root.rCount++;
        } else {
            root.left = insertHelper(root.left, newPlayer);
        }
        return root;
    }

    /**
     * finds the top scoring player
     * @param root of Tree
     * @return top score
     */
    public int goRight(TreeNode root) {
        //right most of leaf
        //base case - right has no more child, return my own score since it will be the largest
        if(root.right == null) {
            return root.player.score;
        }
        int score = goRight(root.right);
        return score;
    }

    /**
     * calls delete node method and delete node containing the old score, insert new player with new score
     * @param targetPlayer of player with the old score
     * @param newScore of said player that will be reinserted
     */
    public boolean updateScore(Player targetPlayer, int newScore) {
        if (targetPlayer.score < newScore) {
            //find and delete player with said score
            this.root = deleteNode(this.root, targetPlayer.score); //updated score
            Player replacePlayer = new Player(targetPlayer.playerId, newScore);
            //insert new node with new score with same ID
            this.insert(replacePlayer);
            return true;
        }
        return false;
    }

    /**
     * finds the node, delete the node with 3 cases
     * 1. has no child - replace with null immediately
     * 2. has 1 child - replace with the other child
     * 3. has 2 children - take smallest value on right subtree to replace with tobeDeleted
     * @param root of current scoreTree
     * @param findScore the target score we are trying to delete
     * @return the updated tree back
     */
    private TreeNode deleteNode(TreeNode root, int findScore) { //suppose to find OLD SCORE
        //corner case
        if (root == null) {
            return null;
        }

        //go left or go right - recursive rule
        if (root.player.score < findScore) {
            root.right = deleteNode(root.right, findScore);
            return root;
        } else if (root.player.score > findScore) {
            root.left = deleteNode(root.left, findScore);
            return root;
        }

        //no longer needed traversal, root == key
        //has no child or only one
        if (root.left == null && root.right == null) {
            return null; // connects null with it's parent
        } else if (root.right == null) {
            return root.left;
        } else if (root.left == null) {
            return root.right;
        }

        //have 2 children. find the smallest node in the RIGHT subtree
        //if no smallest node on left, i.e. null
        if (root.right.left == null) {
            root.right.left = root.left; //it's left subtree will still satisfy BST invariant
            return root.right;
        } else {
            TreeNode smallest = deleteSmallest(root.right);
            smallest.left = root.left;
            smallest.right = root.right; //"takes over" root as 'new' root
            return smallest;
        }
    }
    private TreeNode deleteSmallest(TreeNode root) {
        //keep going left until no tomorrow
        while (root.left.left != null) {
            root = root.left;
        }
        TreeNode smallestNodeRightSubtree = root.left;
        root.left = root.left.right; // if there is a right child for the smallest node, put that at where the smallestNode was originally
        return smallestNodeRightSubtree;
    }

    /**
     * calls helper function to find  kth highest scoring player
     * @param position of the highest scoring player we are looking for
     * @return player id
     */
    public int rankingPosition(int position) {
        TreeNode result = kthHighestScoredPl(this.root, position);
        if (result == null) {
            return -1;
        }
        return result.player.playerId;
    }

    /**
     * helper function to find the kth highest scoring player
     * @param root of tree node for traversal
     * @param k denotes position we are trying to find
     * @return TreeNode in that location
     */
    private TreeNode kthHighestScoredPl(TreeNode root, int k) {

        //base case
        if (root == null) {
            return null;
        }

        //count denotes- at this root position, how many more nodes are to it's right subtree
        //if there are T nodes in its right subtree, means there are T nodes that have higher score than current root
        int count = root.rCount + 1;
        if (count == k) {
            return root;
        }

        //if the current node's ranking is higher than k, means that we have to keep looking for another higher player
        if (count > k) {
            return kthHighestScoredPl(root.right, k);
        }

        //otherwise, look left for lower scored player
        //k - count denotes: the current K is overshot of root position's ranking, so we move left to find smaller
        //and we subtract the root's ranking from K to get the highest possible ranking AFTER root position.
        return kthHighestScoredPl(root.left, k - count);

    }



    //driver method for test
    public static void main(String[] args) {
        List<Player> playerInfo = new ArrayList<Player>();
        Player p1 = new Player(1, 20); // 1st arg: playerId, 2nd arg: score
        Player p2 = new Player(4, 4);
        Player p3 = new Player(7, 2);
        Player p4 = new Player(8, 3);
        Player p5 = new Player(10, 60);
        Player p6 = new Player(15, 13);

        playerInfo.add(p1);
        playerInfo.add(p2);
        playerInfo.add(p3);
        playerInfo.add(p4);
        playerInfo.add(p5);
        playerInfo.add(p6);

        BSTbyScore myTree = new BSTbyScore();
        for (int i = 0; i < playerInfo.size(); i++) {
            myTree.insert(playerInfo.get(i));
        }

        myTree.updateScore(p2, 15);
        System.out.println(myTree);
        System.out.println(myTree.rankingPosition(3));


    }

}
