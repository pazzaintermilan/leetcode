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
    time: O(n)
    space: O(n)
    */
    @method1
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(root==null)
            return ret;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode pre=null;
        while(root!=null||!stk.isEmpty()){
            if(root!=null){
                stk.push(root);
                root=root.left;
            }else{
                root=stk.pop();
                if(root.right==pre||root.right==null){
                    ret.add(root.val);
                    pre=root;
                    root=null;
                }else{
                    stk.push(root);
                    root=root.right;
                }
            }
        }
        return ret;
    }

    /*
    non-recursive
    time: O(n)
    space: O(n)
    */
    @method2
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(root==null)
            return ret;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        stk.push(root);
        while(!stk.isEmpty()){
            TreeNode node = stk.pop();
            ret.add(0,node.val);
            if(node.left!=null)
                stk.push(node.left);
            if(node.right!=null)
                stk.push(node.right);
        }
        return ret;
    }
}