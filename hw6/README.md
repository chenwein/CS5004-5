## Final Assignment ##

Files

* LeaderBoard Interface
* LeaderBoardImpl.java
* Player.java
* TreeNode.java
* SegmentNode.java
* SegmentTree.java
* BSTbyID.java
* BSTbyScore.java

__TASK1:__ Build a BST of Player Object, ordered by the playerId, inside your LeaderBoardImpl. Complete the query method. We assume that the player to query always exists in the leaderboard.<br />
__TASK2:__ Complete the update method.<br />
__TASK3:__ Add a second tree (which is a segment tree) to your LeaderBoardImpl. Complete the rangeHighestQuery method. Remember to update the implementation of your constructor and update() method.<br />
__TASK4:__ Add a second BST that stores Player objects ordered by score. Complete the getTopOne() method. And update your update() method. You can assume that all the players’ scores are distinct.<br />
__TASK5:__ Augment the second BST to support playerIdAtPosition(int). Complete the playerIdAtPosition(int) method. Also update your update() method.<br />
