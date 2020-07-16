package BSTwithWords;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BSTFrequency{
    TreeNode root;

    // constructors
    public BSTFrequency(TreeNode root) {
        this.root = root;
    }

    // construct an empty BST
    public BSTFrequency() {
        this.root = null;
    }

    /**
     * adds from a list of Word into this current tree
     * @param list of Words
     */
    public void addListofWord(List<Word> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            this.insert(list.get(i));
        }

    }

    /**
     * insert word nodes into tree, ordering by frequency
     * if frequency is the same, order lexicographically
     * @param newWord object
     */
    public void insert(Word newWord) {
        if (this.root == null) {
            //if there is currently no root for this tree, insert it as the root
            //Create the node
            //assign newWord to newly created node
            TreeNode newRoot = new TreeNode(newWord);
            //assign it to this.root
            this.root= newRoot;
            return;
        }
        //else if there is already a root, recursively add the new word
        insertHelper(this.root, newWord);
    }

    private TreeNode insertHelper(TreeNode root, Word newWord) {
        if (root == null) {
            //base case the current rootWord node is null, insert the rootWord node with this newVocab
            // Replace the null to the caller which is either root.left or root.right
            return new TreeNode(newWord);
        }
        //if frequency is greater than current pointed root, go right
        if (root.word.getOccurence() < newWord.getOccurence()) {
            root.right = insertHelper(root.right, newWord);
        //if frequency is less than current pointed root, go right
        } else if (root.word.getOccurence() > newWord.getOccurence()) {
            root.left = insertHelper(root.left, newWord);
        } else {
            //in the case that s1.frequencey == s2.frequency
            //compare by words
            if (root.word.getVocab().compareToIgnoreCase(newWord.getVocab()) < 0) {
                //insert to the right because newVocab is greater
                root.right = insertHelper(root.right, newWord);
            } else if (root.word.getVocab().compareToIgnoreCase(newWord.getVocab()) > 0) {
                //s1 comes later than s2 and is greater than s2
                root.left = insertHelper(root.left, newWord);
            }
        }
        return root;
    }


    public TreeNode mostFrequent(TreeNode root) {
        //check for root null
        if (root == null) {
            return null;
        }
        TreeNode cur = root;
        while(cur.right != null) {
            cur = cur.right;
        }
        //stop before right == null
        return cur;

    }

    public TreeNode mostFrequentR(TreeNode root) {
        return goRight(root);
    }

    private TreeNode goRight(TreeNode root) {
        if (root.right == null) {
            return root;
        }
        root = goRight(root.right);
        return root;
        //when returned will assign the bottom most node back up through the stack frame
    }

//    private TreeNode goRight(TreeNode root) {
//        if (root.right == null) {
//            return root;
//        }
//        return goRight(root.right);
//        //return root goes back up ONE stack from, then
//        //skips call stack frames and return to first method
//
//    }

    //order least frequent by occurence, then by lexicographic order
    public TreeNode leastFrequent(TreeNode root) {
        //check for root null
        if (root == null) {
            return null;
        }
        TreeNode cur = root;
        while(cur.left != null) {
            cur = cur.left;
        }
        //stop before right == null
        return cur;

    }


}