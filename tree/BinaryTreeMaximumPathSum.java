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
    space: O(n)
    */
    public int maxPathSum(TreeNode root) {
        if(root==null)
            return 0;
        int[] ret = new int[1];
        ret[0]=root.val;
        findMaxSum(root,ret);
        return ret[0];
    }
   
    public int findMaxSum(TreeNode root, int[] ret){
        if(root==null)
            return 0;
        int left=findMaxSum(root.left,ret);
        int right=findMaxSum(root.right,ret);
        int sum=root.val;
        if(left>0)
            sum+=left;
        if(right>0)
            sum+=right;
        if(sum>ret[0])
            ret[0]=sum;
        return Math.max(root.val,Math.max(root.val+left,root.val+right));
    }
}