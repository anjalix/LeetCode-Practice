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
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return 0;
        q.add(root);
        q.add(null);
        TreeNode pop;
        int cnt =0;
        
        while(!q.isEmpty())
        {
            pop = q.remove();
            if(pop == null)
            {
                cnt++;
                if(q.isEmpty())
                    return cnt;
                q.add(null);
                continue;
            }
            if(pop.left!=null)
                q.add(pop.left);
            if(pop.right!=null)
                q.add(pop.right);
        }
        return cnt;
    }
}