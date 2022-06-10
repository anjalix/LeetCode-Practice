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
    public TreeNode buildTree(int[] preorder, int pre_left, int pre_right, int in_left, int in_right) {        
        if(pre_left > pre_right || in_left > in_right)
            return null;
        if(pre_left == pre_right)
           return new TreeNode(preorder[pre_left]);
        int pos = inorderMap.get(preorder[pre_left]);
        TreeNode root = new TreeNode(preorder[pre_left]);
        root.left = buildTree(preorder, pre_left+1 , pre_left + pos-in_left , in_left , pos-1 );
        root.right = buildTree(preorder, pre_left + pos-in_left+1, pre_right, pos+1 , in_right);
        return root;    
    }
    
    HashMap<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i<inorder.length; i++)
            inorderMap.put(inorder[i], i);
        return buildTree(preorder,0,preorder.length-1,0,inorder.length-1);
    }
}