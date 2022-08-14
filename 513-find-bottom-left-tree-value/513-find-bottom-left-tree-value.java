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
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(null);
        TreeNode node = root;
        TreeNode ans = root;
        while(!q.isEmpty()) {
            node = q.remove();
            if(node == null) {
                if(!q.isEmpty()) {
                    ans = q.peek();
                    q.add(null);
                }
            }
            else {
                if(node.left!= null)
                    q.add(node.left);
                if(node.right!= null)
                    q.add(node.right);
            }
        }
        return ans.val;
    }
}