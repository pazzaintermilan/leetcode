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
    time: O(n) you need to traverse all nodes
    space: O(n)
    */
    @method1
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> ret=new ArrayList<Integer>();
        if(root==null)
            return ret;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        while(root!=null||!stk.isEmpty()){
            if(root!=null){
                ret.add(root.val);
                stk.push(root);
                root=root.left;
            }else{
                root=stk.pop();
                root=root.right;
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
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> ret=new ArrayList<Integer>();
        if(root==null)
            return ret;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        stk.push(root);
        while(!stk.isEmpty()){
            TreeNode node = stk.pop();
            ret.add(node.val);
            if(node.right!=null)
                stk.push(node.right);
            if(node.left!=null)
                stk.push(node.left);
        }
        return ret;
    }

    /*
    recursive
    time: O(n)
    space: O(n)
    */
    @method3
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        preorderHelper(root,ret);
        return ret;
    }
    
    public void preorderHelper(TreeNode root, ArrayList<Integer> ret){
        if(root==null)
            return;
        ret.add(root.val);
        preorderHelper(root.left,ret);
        preorderHelper(root.right,ret);
    }


    /*
    morris
    time: O(n)
    space: O(1)
    */
    @method4
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        while(root!=null){
            if(root.left!=null){
                TreeNode tmp=root.left;
                while(tmp.right!=null&&tmp.right!=root)
                    tmp=tmp.right;
                if(tmp.right==null){
                    ret.add(root.val);
                    tmp.right=root;
                    root=root.left;
                }else{
                    tmp.right=null;
                    root=root.right;
                }
            }else{
                ret.add(root.val);
                root=root.right;
            }
        }
        return ret;
    }

}