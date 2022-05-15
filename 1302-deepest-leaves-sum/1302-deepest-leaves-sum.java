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
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode > q = new LinkedList<>();
        if(root == null) return 0;
        q.add(root);
        q.add(null);
        TreeNode temp;
        int level = 0;
        int sum = 0;
        while(!q.isEmpty())
        {
            temp = q.peek();
            if(temp == null)
            {
                q.remove();
                if(q.isEmpty()) break;
                sum = 0;
                q.add(null);
            }
            else
            {
             q.remove();
             if(temp.left!=null) q.add(temp.left);
             if(temp.right!=null) q.add(temp.right);
             sum = sum + temp.val;
            }
        }
        return sum;
    }
}