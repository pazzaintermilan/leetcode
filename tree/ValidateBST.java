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
    recursive
    time: O(n)
    space: O(logn)
    */
    @method1
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean isValidBST(TreeNode node, long min, long max){
        if(node==null)
            return true;
        if(node.val<=min||node.val>=max)
            return false;
        return isValidBST(node.left,min,node.val)&&isValidBST(node.right,node.val,max);
    }


    /*
    non-recursive
    time: O(n)
    space: O(logn) or height of tree
    */
    @method2
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stk=new Stack<TreeNode>();
        TreeNode pre=null;
        while(root!=null||!stk.isEmpty()){
            if(root!=null){
                stk.push(root);
                root=root.left;
            }else{
                root=stk.pop();
                if(pre==null){
                    pre=root;
                }else{
                    if(pre.val>=root.val)
                        return false;
                    pre=root;
                }
                root=root.right;
            }
        }
        return true;
    }

}