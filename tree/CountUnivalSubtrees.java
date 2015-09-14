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
    */
    @method1
    public int countUnivalSubtrees(TreeNode root) {
        if(root==null)
            return 0;
        int count=0;
        if(isUnivalSubtrees(root))
            return 1+countUnivalSubtrees(root.left)+countUnivalSubtrees(root.right);
        else
            return countUnivalSubtrees(root.left)+countUnivalSubtrees(root.right);
    }
    
    public boolean isUnivalSubtrees(TreeNode root){
        if(root==null)
            return false;
        Stack<TreeNode> stk=new Stack<TreeNode>();
        int val=root.val;
        while(root!=null||!stk.isEmpty()){
            if(root!=null){
                if(root.val!=val)
                    return false;
                stk.push(root);
                root=root.left;
            }else{
                root=stk.pop();
                root=root.right;
            }
        }
        return true;
    }

    @method2
    public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];
        helper(root, count);
        return count[0];
    }

    private boolean helper(TreeNode node, int[] count) {
        if (node == null) 
            return true;
        boolean left = helper(node.left, count);
        boolean right = helper(node.right, count);
        if (left && right) {
            if (node.left != null && node.val != node.left.val) 
                return false;
            if (node.right != null && node.val != node.right.val) 
                return false;
            count[0]++;
            return true;
        }
        return false;
    }
}