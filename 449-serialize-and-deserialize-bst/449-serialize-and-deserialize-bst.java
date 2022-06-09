/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    int pos;
    public String preOrder(TreeNode root, String ans) {
        if(root == null)
            return ans;
        ans = ans + " " + root.val;
        ans = preOrder(root.left , ans);
        ans = preOrder(root.right , ans);
        return ans;
    }
    

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String ans = preOrder(root,"");
        return ans;
    
    }

    public TreeNode bstFromPreOrder(String[] data, int bound) {
        if(pos == data.length || (Integer.parseInt(data[pos])>bound))
            return null;  
        TreeNode root = new TreeNode(Integer.parseInt(data[pos]));
        pos++;
        root.left = bstFromPreOrder(data, root.val);
        root.right = bstFromPreOrder(data, bound);    
        return root;    

    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        pos = 1;        
        String[] s = data.split(" ");
        return bstFromPreOrder(s, Integer.MAX_VALUE);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;