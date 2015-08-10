/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    Stack<TreeNode> stk=new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        while(root!=null){
            stk.push(root);
            root=root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(stk.isEmpty())
            return false;
        else
            return true;
    }

    /** @return the next smallest number */
    public int next() {
        int ret=0;
        if(!stk.isEmpty()){
            TreeNode node=stk.pop();
            ret=node.val;
            node=node.right;
            while(node!=null){
                stk.push(node);
                node=node.left;
            }
        }
        return ret;
    }
}