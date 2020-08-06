package assignment6;

public class SegmentNode {

    //fields
    int startID;
    int endID;
    int maxScore;
    SegmentNode left;
    SegmentNode right;

    //constructor
    public SegmentNode(int startID, int endID) {
        this.startID = startID;
        this.endID = endID;
        this.maxScore = -1;
        this.left = null;
        this.right = null;
    }

    public SegmentNode(int startID, int endID, int maxScore) {
        this.startID = startID;
        this.endID = endID;
        this.maxScore = maxScore;
        this.left = null;
        this.right = null;
    }
}
