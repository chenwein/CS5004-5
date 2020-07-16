package BSTwithWords;


import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class BinarySearchTree implements Iterable<Word> {
    TreeNode root;

    // constructors
    public BinarySearchTree(TreeNode root) {
        this.root = root;
    }

    // construct an empty BST
    public BinarySearchTree() {
        this.root = null;
    }

    /** iterator implementation next class */

    class BSTIterator implements Iterator<Word> {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Word next() {
            return null;
        }
    }

    @Override
    public Iterator<Word> iterator() {
        return new BSTIterator();
    }

    /**
     * method iterates through a list of word and starts populating tree
     * @param wordList of a list of words
     */
    public void addWords(List<String> wordList) {
        for (int i = 0; i < wordList.size(); i++) {
            Word thisWord = new Word(wordList.get(i));
            this.insert(thisWord);
        }
    }

    /**
     * method takes in a string and parse it into Arraylist of words
     * @param wordList String representing a sentence
     */
    public void addSentenceofWord(String wordList) {
        String[] array = wordList.split(" ");
        List<String> newList = Arrays.asList(array);
        this.addWords(newList);
    }


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
        if (root == null) { //rootword is the pointer, this.rootWord set the root of THIS tree.
            //base case the current rootWord node is null, insert the rootWord node with this newVocab
            // Replace the null to the caller which is either root.left or root.right
            return new TreeNode(newWord);
        }
        //if string1 > string 2 - positive value
        //string 1 < string 2 - negative value  [comes later is greater]
        if (root.word.getVocab().compareToIgnoreCase(newWord.getVocab()) < 0) {
            //insert to the right because newVocab is greater
            root.right = insertHelper(root.right, newWord);
        } else if (root.word.getVocab().compareToIgnoreCase(newWord.getVocab()) > 0) {
            //s1 comes later than s2 and is greater than s2
            root.left = insertHelper(root.left, newWord);
        } else {
            //in the case that s1 == s2
            //increment the occurence by 1 and dont insert node
            root.word.setOccurence(root.word.getOccurence() + 1);
            return root;
        }

        return root;
    }

    public List<Word> popToList() {
        List<Word> result = new ArrayList<Word>();
        postOrderHelper(this.root, result);
        return result;
    }

    public void postOrderHelper(TreeNode root, List<Word> result) {
        //base case
        if (root == null) {
            return;
        }
        postOrderHelper(root.left, result);
        postOrderHelper(root.right, result);
        result.add(root.word);
        //traverse left
        //traverse right
        //root
    }




    public static void main(String[] args) {
        //driver test method
        BinarySearchTree wordTree = new BinarySearchTree();
        List<String> listOfWords = new ArrayList<String>();
        listOfWords.add("hello");
        listOfWords.add("Beyonce");
        listOfWords.add("Applebee");
        listOfWords.add("Beyonce");
        listOfWords.add("Beyonce");
        listOfWords.add("Girrafe");
        listOfWords.add("Kanye");
        listOfWords.add("Reynolds");
        listOfWords.add("Hugh");
        listOfWords.add("Hugh");
        listOfWords.add("Tom");
        //call add word method
//        wordTree.addWords(listOfWords);

        /** not implemented Iterator */

//        List<Word> result = wordTree.popToList();
//        for (int i = 0; i < result.size(); i++) {
//            System.out.println(result.get(i).getVocab());
//        }
//
//        BSTFrequency two = new BSTFrequency();
//        two.addListofWord(result);
//
//       TreeNode a = two.mostFrequentR(two.root);
//        System.out.println("most" + a.word.getOccurence());

        //test string parser
        String s = "he was a good boy a really good boy";
        wordTree.addSentenceofWord(s);
        System.out.println(wordTree);


    }

}
