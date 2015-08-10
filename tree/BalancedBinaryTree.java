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
    space: height of tree
    */
    public boolean isBalanced(TreeNode root) {
        return balancedHeight(root)>=0;
    }
    
    /*
    return the height of root if root is a balanced tree,
    otherwise return -1
    */
    public int balancedHeight(TreeNode root){
        if(root==null)
            return 0;
        int left=balancedHeight(root.left);
        int right=balancedHeight(root.right);
        if(left<0||right<0||Math.abs(left-right)>1)
            return -1;
        return Math.max(left,right)+1;
    }
}