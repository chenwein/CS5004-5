package BST;

import java.util.Scanner;

public class TestBST {
    public static void main(String[] args) {
        //create scanner object to read input from terminal
        Scanner input = new Scanner(System.in);
        System.out.println("how many numbers?");
        int n = input.nextInt();
        int[] nums = new int[n];
        System.out.println("Type in the numbers for array");
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }

        TreeNode root = new TreeNode (nums[0]);
        binarySearchTree bst = new binarySearchTree(root);
        //start from 1 because first string already used as root
        for (int i = 1; i < nums.length ; i++) {
            int value = nums[i];
            bst.insert(value);
        }
        bst.levelOrderedTraversal();
        System.out.println("End Program");

    }
}
