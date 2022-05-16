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

/*
Solution 1: Queue Based Implementation
@author: Anjali


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

*/

/*
Solution 2:

*/

class Solution {
 
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        if(root.left == null)
            return 1 + maxDepth(root.right);
        if(root.right == null)
            return 1 + maxDepth(root.left);
        int left = maxDepth(root.right);
        int right = maxDepth(root.left);
        return Math.max(left,right)+1;    
    }
}