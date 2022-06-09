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
    int i = 0;
    int ans = 0;
    
    public void inorder(TreeNode root, int k) {
        if(root == null || i>=k)
            return;
        inorder(root.left, k);
        i++;
        if(i == k)
            ans = root.val;
        inorder(root.right, k);
        return;
    }
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return ans;
    }
}