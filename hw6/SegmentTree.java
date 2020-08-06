package assignment6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SegmentTree {
    //i feel like this tree should be worth 100 points

    //list of player with ID sorted
    //access the score for maxScore
    SegmentNode root;

    //constructors
    public SegmentTree(SegmentNode node) {
        this.root = node;
    }

    public SegmentTree(List<Player> list) {
        //constructs segment tree
        Collections.sort(list, (o1, o2) -> o1.playerId - o2.playerId);
        //starting default segment node
        int last = list.size() - 1;
        SegmentNode myNode = new SegmentNode(list.get(0).playerId, list.get(last).playerId);
        //initialize segment tree with default node and build tree
        this.root = myNode;
        this.buildBottomUp(list, this.root, 0, list.size() - 1);
    }

    /**
     * builds SegmentTree from bottom up given input of playerList
     * @param list of PlayerObject
     * @param root placeholder root for Segment tree default max = -1;
     * @param start index of List
     * @param end index of LIST
     * @return original Segment Tree root with updated maxScore , max(L, R)
     */
    public SegmentNode buildBottomUp(List<Player> list, SegmentNode root,int start,int end) {
        if (start == end){
            root.maxScore = list.get(start).score;
            return root;
        }
        int mid = start + (end - start) / 2;
        //placeholder segment nodes to allow recursion to keep traveling
        root.left = buildBottomUp(list, new SegmentNode(list.get(start).playerId, list.get(mid).playerId), start, mid);
        root.right = buildBottomUp(list, new SegmentNode(list.get(mid + 1).playerId, list.get(end).playerId), mid + 1 , end);
        //pick max of children
        root.maxScore = Math.max(root.left.maxScore, root.right.maxScore);
        return root;

    }

    /**
     *  returns maxScore given range of playerID
     * @param curr pointer to root of Segment Tree, for traversal
     * @param queryStart of query range
     * @param queryEnd of query range
     * @return highest score
     */
    public int highestQuery(SegmentNode curr, int queryStart, int queryEnd) {
        //case 1. current segmentNode is part of given range, give its maxScore
            //query start <= segment start AND query end >= segment end
        if (queryStart <= curr.startID && queryEnd >= curr.endID ) {
            return curr.maxScore;
        }

        //case 2. query range out of bounds for curr segmentNode, return -1, the smallest value
            //segment end < query start OR segment start > query end
        if (queryStart > curr.endID || queryEnd < curr.startID) {
            return -1; //or integerMIN
        }

        //case 3. segment is partially within the range, recursively return maxScore of L, R
        int queryLeft = highestQuery(curr.left, queryStart, queryEnd);
        int queryRight = highestQuery(curr.right, queryStart, queryEnd);
        return Math.max(queryLeft, queryRight);

    }

    /**
     * calls helper function
     * @param targetID of player
     * @param newScore score to update for said player
     * @return true if update successful
     */
    public boolean updateBottomNode(int targetID, int newScore) {
        updateHelper(root, targetID, newScore);
        return true;
    }

    /**
     * helper function to travers to the bottom level of tree where nodes are separated into individual Segment nodes (and no longer part of a range)
     * @param curr pointer to the root
     * @param targetID of player
     * @param newMaxScore to replace curr.maxScore
     */
    private void updateHelper(SegmentNode curr, int targetID, int newMaxScore) {
        //base case
        //arrived at last node, update the score (sanity check already done at BST so dont have to check if its higher)
        if (curr.startID == curr.endID) {
            curr.maxScore = newMaxScore;
            return;
        }

        //recursive rule
        //case 1. targetID is within left bound of left child (inclusive boundary)
        //case 2. targetID is greater than START of right bound (inclusive boundary)
        if (targetID <= curr.left.endID) {
            updateHelper(curr.left, targetID, newMaxScore);
        } else {
            updateHelper(curr.right, targetID, newMaxScore);
        }
    }

    public static void main(String[] args) {

        //list of player info
        List<Player> playerInfo = new ArrayList<Player>();
        Player p1 = new Player(1, 20);
        Player p2 = new Player(4, 4);
        Player p3 = new Player(7, 2);
        Player p4 = new Player(8, 3);
        Player p5 = new Player(10, 60);
        Player p6 = new Player(15, 13);


        playerInfo.add(p4);
        playerInfo.add(p2);
        playerInfo.add(p5);
        playerInfo.add(p1);
        playerInfo.add(p6);
        playerInfo.add(p3);

        //没有natural order， 需要自己定义comparator
        //call Collections.sort using comparator
        Collections.sort(playerInfo, (o1, o2) -> o1.playerId - o2.playerId);


        //starting segment node
        int last = playerInfo.size() - 1;
        SegmentNode myNode = new SegmentNode(playerInfo.get(0).playerId, playerInfo.get(last).playerId);

        //empty segment Tree
        SegmentTree myTree = new SegmentTree(myNode);

        myTree.buildBottomUp(playerInfo, myTree.root, 0, playerInfo.size() - 1);

        int result = myTree.highestQuery(myTree.root, 5, 9);
        System.out.println(result);

        myTree.updateBottomNode(10, 5);

    }


// https://stackoverflow.com/questions/12688394/how-to-construct-binary-search-tree-bottom-up
}
