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
/* Solution 2: Non-Recursion
*/
class Solution {
    public void flatten(TreeNode root) {
        TreeNode node = root;
        while(node!= null) {
            TreeNode right = node.right;
            TreeNode left = node.left;
            if(left!= null) {
                TreeNode temp = left;
                while(temp.right!= null)
                    temp = temp.right;            
                temp.right = right;
                node.right = left;
                node.left = null;
            }            
            node = node.right;
        }
    }
    
}
      

/*
Solution 1 :
Recursion

class Solution {
    
    TreeNode prev = null;
    
    public void flatten(TreeNode root) {
        
        if(root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
*/