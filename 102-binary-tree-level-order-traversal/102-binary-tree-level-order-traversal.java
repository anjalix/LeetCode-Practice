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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> temp_ans = new ArrayList<Integer>();
        if(root == null) 
            return ans;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(null);
        TreeNode node;
        while(q.size()!=0)
        {
           node = q.remove();
            if(node == null) {
              ans.add(temp_ans);
              temp_ans = new ArrayList<Integer>();
                if(q.size()!=0)
                    q.add(null);  
            }
            else {
                temp_ans.add(node.val);
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
            }
        }
        return ans;
    }
}