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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode top,temp;
        q.add(root);
        while(!q.isEmpty()) {
            top = q.remove();
            temp = top.left;
            top.left = top.right;
            top.right = temp;
            if(top.left != null)
                q.add(top.left);
            if(top.right != null)
                q.add(top.right);  
        }
        return root;
    }
}