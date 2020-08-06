package assignment6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeaderBoardImpl implements LeaderBoard {

    //fields
    BSTbyID bstByID;
    SegmentTree segmentTree;
    BSTbyScore bstByScore;


    //constructor takes list of player objects
    //constructs 3 BSTs
    public LeaderBoardImpl(List<Player> playerInfo){
        bstByID = new BSTbyID(playerInfo);
        bstByScore = new BSTbyScore(playerInfo);
        segmentTree = new SegmentTree(playerInfo);
    }

    /**
     * given player ID, return the player's score
     * @param id of the player who's score we want to query
     * @return the score of said player
     */
    @Override
    public int scoreQuery(int id) {
        TreeNode result = bstByID.find(id);
        return result.player.score;
    }

    /**
     * updates a given player's score
     * @param id of the player we want to perform the score update
     * @param score new score we want said player to have
     * @return true if success update, false if this id does not exist
     */
    @Override
    public boolean update(int id, int score) {
        //find by ID, update bstBySCore first
        //subsequently update rest of trees
        TreeNode target = bstByID.find(id);
        return bstByScore.updateScore(target.player, score) && bstByID.updateScore(id, score) && segmentTree.updateBottomNode(id, score);
    }


    /**
     * sorts list by ID, then call SegmentTree query function
     * @param low_id start range of player ID
     * @param high_id end range of player ID
     * @return highest score within said player Range
     */
    @Override
    public int rangeHighestQuery(int low_id, int high_id) {
        return segmentTree.highestQuery(segmentTree.root, low_id, high_id);
    }

    /**
     * retrieves the top scoring player's score
     * @return top score
     */
    @Override
    public int getTopOne() {
        return bstByScore.goRight(bstByScore.root);
    }

    /**
     * retrieves player ID at the i th scoring position
     * @param pos desired to retrieve
     * @return  player ID
     */
    @Override
    public int playerIdAtPosition(int pos) {
        //returns -1 if position does not exist (less than k nodes
        // 1 2 3 4 5 - 3rd highest score k = 2, 2nd highest score, k = 1, highest score
        return bstByScore.rankingPosition(pos);

    }
}