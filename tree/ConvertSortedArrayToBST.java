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
    space: O(logn) or height of tree
    */
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums,0,nums.length-1);
    }
    
    public TreeNode buildBST(int[] nums, int beg, int end){
        if(beg>end)
            return null;
        int mid=(beg+end)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=buildBST(nums,beg,mid-1);
        root.right=buildBST(nums,mid+1,end);
        return root;
    }
}