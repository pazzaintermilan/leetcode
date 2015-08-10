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
    non-recursive
    time: O(logn)
    space: O(1)
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true){
            boolean isRoot=(root.val-p.val)*(root.val-q.val)<=0;
            if(isRoot)
                return root;
            if(p.val<root.val)
                root=root.left;
            else
                root=root.right;
        }
    }

    /*
    recursive
    time: O(logn)
    space: height of tree
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if((root.val-p.val)*(root.val-q.val)<=0) 
            return root;
        else if(root.val>p.val) 
            return lowestCommonAncestor(root.left,p,q);
        else 
            return lowestCommonAncestor(root.right,p,q);
    }
}