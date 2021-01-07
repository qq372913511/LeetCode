import java.util.LinkedList;

public class l104 {

}



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


/**
 * 普通的基于广度优先搜索的，时间复杂度很高
 */

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addLast(root);

        int max = 0;
        while(!queue.isEmpty() ){
            ++max;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.pollFirst();
                if (treeNode.left !=null){
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null){
                    queue.add(treeNode.right);
                }
            }
        }
        return max;
    }
}


