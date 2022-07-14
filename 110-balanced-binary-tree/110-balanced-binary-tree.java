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
    public int height(TreeNode root) {
        if(root == null)
            return -1;
        if(root.left == null && root.right == null)
            return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return 1 + Math.max(leftHeight, rightHeight);            
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right); 
        if(isBalanced(root.left) && isBalanced(root.right) && (leftHeight == rightHeight || leftHeight == rightHeight+1 || 
           leftHeight + 1 == rightHeight))
            return true;
        return false;
    }
}