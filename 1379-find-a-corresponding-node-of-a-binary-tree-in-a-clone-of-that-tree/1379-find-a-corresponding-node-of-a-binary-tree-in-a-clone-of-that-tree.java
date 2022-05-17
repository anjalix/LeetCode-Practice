/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == target)
            return cloned;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(original);
        q.add(cloned);
        TreeNode pop_original, pop_cloned;
        while(!q.isEmpty()) {
            pop_original = q.remove();
            pop_cloned = q.remove();
            if(pop_original == target)
                return pop_cloned;
            if(pop_original.left!=null)
            {
                q.add(pop_original.left);
                q.add(pop_cloned.left);
            }
            if(pop_original.right!=null)
            {
                q.add(pop_original.right);
                q.add(pop_cloned.right);
            }                        
        }
        return cloned;
    }
}