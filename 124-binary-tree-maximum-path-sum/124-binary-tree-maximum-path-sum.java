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
    int maxSum = Integer.MIN_VALUE;
    
    public int maxPathSumUtil(TreeNode root) {
        if(root == null)
            return 0;
        int left = maxPathSumUtil(root.left);
        int right = maxPathSumUtil(root.right);
        if(left>0 && right>0)
            maxSum = Math.max(maxSum, root.val + left + right);
        else
            maxSum = Math.max(maxSum, root.val + Math.max(0, Math.max(left,right)));
        return root.val + Math.max(0, Math.max(left,right)); 
    }
    
    public int maxPathSum(TreeNode root) {
        maxPathSumUtil(root);
        return maxSum;
    }
}