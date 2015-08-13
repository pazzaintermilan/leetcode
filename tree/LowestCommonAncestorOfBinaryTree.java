/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    /*
    time: O(n)
    space: space(logn)
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q)
            return root;
        else {
            TreeNode leftAncester = lowestCommonAncestor(root.left, p, q);
            TreeNode rightAncester = lowestCommonAncestor(root.right, p, q);
            if(leftAncester!=null&&rightAncester!=null)
                return root;
            else
                return leftAncester!=null?leftAncester:rightAncester;
        }
    }
}