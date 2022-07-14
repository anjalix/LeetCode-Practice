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
    
    HashMap<Integer, Integer> inorderHmap;
    
    public TreeNode buildTree(int[] preorder, int[] inorder, int p_start, int p_end, int i_start, int i_end) {
        
        if(p_start > p_end || i_start > i_end || i_end < 0 || p_end < 0 || p_start >= preorder.length || i_start >= inorder.length)
            return null;
        
        TreeNode root = new TreeNode(preorder[p_start]);
                
        if(p_start == p_end)
            return root;

        int index = inorderHmap.get(preorder[p_start]);
        root.left  = buildTree(preorder, inorder, p_start+1, p_start+index-i_start , i_start, index-1);
        root.right = buildTree(preorder, inorder, p_start+index-i_start+1, p_end, index+1, i_end);
        return root;    
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int pl = preorder.length;
        int il = inorder.length;
        if(pl == 1)
            return new TreeNode(preorder[0]);
        
        inorderHmap = new HashMap<Integer, Integer>();
        for(int i = 0; i<il; i++) {
            inorderHmap.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, pl, 0, il);    
    }
}