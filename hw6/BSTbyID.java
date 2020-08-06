package assignment6;

import java.util.ArrayList;
import java.util.List;

public class BSTbyID {
    TreeNode root;

    //constructors

    //with root
    public BSTbyID(TreeNode root ) {
        this.root = root;
    }

    //empty
    public BSTbyID() {
        this.root = null;
    }

    //constructor takes list of player
    public BSTbyID(List<Player> list) {
        for (int i = 0; i < list.size(); i ++) {
            this.insert(list.get(i));
        }
    }

    /**
     * method takes a new player object and builds a binary search tree based on ID
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

        //if node.player.id > root.player.id - go right
        //if node.player.id < root.player.id - go left
        //comparing with int, can use regular operators
        //assuming player ID is unique, no ambiguity, no else
        if (newPlayer.playerId > root.player.playerId) {
            root.right = insertHelper(root.right, newPlayer);
        } else {
            root.left = insertHelper(root.left, newPlayer);
        }
        return root;
    }


    /**
     * given targetID, return node with said playerID
     * @param targetID
     * @return Node containing the correct player
     */
    public TreeNode find(int targetID) {
        //pass to helper with current tree root(in order to navigate tree) and the targetID
        return findHelper(this.root, targetID);
    }

    /**
     * find the treenode with the given playerID
     * @param targetID
     * @return treenode containing the said playerID
     */
    private TreeNode findHelper(TreeNode root, int targetID) {
        //recursively find the player
        //base case
        if (root == null || root.player.playerId == targetID) {
            return root;
        }

        //if not root, look left if playerID < root
        //it not root, look right if playerID > root
        TreeNode result = null;
        if (root.player.playerId > targetID) {
            result =  findHelper(root.left, targetID);
        } else {
            result =  findHelper(root.right, targetID);
        }
        return result;
    }

    /**
     * updates the given target player's score, if the new score is lower than current score, don't update
     * @param targetID
     * @param newScore
     * @return true if whether there is an update or not. return false if there is no given target player in Tree
     */
    public boolean updateScore(int targetID, int newScore) {
        //first find the player, if it is null that means no player exists
        //if found player, update its score if new score is higher
        TreeNode foundTargetNode = find(targetID);
        if (foundTargetNode == null) {
            return false;
        }
        if (foundTargetNode.player.score < newScore) {
            foundTargetNode.player.score = newScore;
        }
        return true;
    }

    //driver method for testing
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

        BSTbyID myTree = new BSTbyID();
        for (int i = 0; i < playerInfo.size(); i++) {
            myTree.insert(playerInfo.get(i));
        }

        TreeNode result = myTree.find(3);
        System.out.println(result.player.score);

        myTree.updateScore(3,100);
        TreeNode newResult = myTree.find(3);
        System.out.println(newResult.player.score);

    }



}
