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
    
    
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        int leftHeight=getHeight(root.left);
        int rightHeight=getHeight(root.right);
        int diff=Math.abs(leftHeight-rightHeight);
        if(diff>1)
            return false;
        else
            return isBalanced(root.left)&&isBalanced(root.right);
    }
    
    public int getHeight(TreeNode root){
        if(root==null)
            return 0;
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }
}