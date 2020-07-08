package BST;

import java.util.*;

public class binarySearchTree {
        // member variable
        TreeNode root;

        // constructor

        // construct a binary tree with given root
        public binarySearchTree(TreeNode root) {
            this.root = root;
        }

        // construct an empty binary tree
        public binarySearchTree() {
            this.root = null;
        }




        // insert an integer into BST
        // assume BST already has a root node and has no duplicates
        boolean insert(int val) {
        //iterative
            //if there is no root/ edge case
            if (root == null) {
                root = new TreeNode(val);
                return true;
            }

            //pointer to traverse tree
            TreeNode current = root;
            while (current.val != val) {
                //go left
                //2 cases
                // 1. there is no left child, so set new value as left child
                // 2. there is a left child, you keep going left
                if (val < current.val) {
                    if (current.left == null) {
                        current.left = new TreeNode(val);
                    }
                    current = current.left;
                    //re loops and evaluate over again
                } else {
                    //go right
                    if (current.right == null) {
                        current.right = new TreeNode(val);
                    }
                    current = current.right;
                }
            }
            return true;
        }

        //recurisve insert
        boolean insertRecurse(int val) {
            TreeNode newNode = insertHelper(root,val);
            if (newNode.val == val) {
                return true;
            } else {
                return false;
            }
        }

        TreeNode insertHelper(TreeNode root, int val) {
            //base case
            if (root == null) {
                root = new TreeNode(val);
                return root;
            }

            //sub problem, each child node is the root node of the sub problem
            //completely skips over duplicate values, and just return
            if (val > root.val) {
                root.right = insertHelper(root.right, val);
            } else if (val < root.val) {
                root.left = insertHelper(root.left, val);
            }
            return root;
        }





        @Override
        public String toString() {
            return super.toString();
        }

        // find the TreeNode which has value `val`
        public TreeNode find(int target) {
            return findHelper(this.root, target);
        }

        private TreeNode findHelper(TreeNode cur, int target) {
            // base case
            if (cur == null) {
                return null;
            }

            // if i have value `val`, then return myself
            if (cur.val == target) {
                return cur;
            }

            // recursively call findHelper on my children
            // to let my children help me find the target
            TreeNode leftRes = findHelper(cur.left, target);
            TreeNode rightRes = findHelper(cur.right, target);

            if (leftRes != null) {
                return leftRes;
            }
            if (rightRes != null) {
                return rightRes;
            }
            return null;
        }

        // remove the TreeNode which has value `val`
        void remove(int val) {
            //original remove replaces the left most child,  aka the smallest child of a subtree, with the to-be-deleted node
            // after swapping it deletes the left most child (which is now the to-be-deleted node)
            //the original code wouldnt' work anymore because it wouldn't satisfy the Binary Search Tree Invariant
            //since this is a Binary Search Tree, we only have to search on side of the sub tree, greatly reducing the time complexity

            //after finding the node to be deleted, we encounter 4 situations
            // 1. the node is a leaf node, we can simply remove it
            // 2. it has one child, than the immediate child will become it's successor
            //     this works because any child that is below the deleted node will still satisfy the BST invariant
            // 3. 4. the node has 2 childs, in this case we can choose 2 successor:
            //      a. largest value in the left subtree
            //      b. smallest value in the right subtree

            }


        public void levelOrderedTraversal() {
            Queue<TreeNode> q = new LinkedList<>();

            // push the root into the queue
            if (this.root != null) {
                q.offer(this.root);
            }

            while(q.isEmpty() != true) {
                // pop out the first node in the queue
                TreeNode firstNodeInQ = q.poll();

                // print out the value of the node
                System.out.println(firstNodeInQ.val);

                // push firstNodeInQ's children, if any, into the queue
                if (firstNodeInQ.left != null) {
                    q.offer(firstNodeInQ.left);
                }
                if (firstNodeInQ.right != null) {
                    q.offer(firstNodeInQ.right);
                }
            }
        }

}

