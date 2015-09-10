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
    time: O(k)
    space: O(n)
    */
    @method1
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> buffer = new ArrayList<Integer>();
        inorderSearch(root, buffer, k);
        return buffer.get(k-1);
    }
    
    private void inorderSearch(TreeNode node, ArrayList<Integer> buffer, int k){
        if(buffer.size()>=k)
            return;
        if(node.left!=null)
            inorderSearch(node.left,buffer,k);
        buffer.add(node.val);
        if(node.right!=null)
            inorderSearch(node.right,buffer,k);
    }

    /*
    non-recursive
    time: O(k)
    space: O(n)
    */
    @method2
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack=new Stack<TreeNode>();
        int c=0;
        TreeNode cur=root;
        while(cur!=null){
            stack.push(cur);
            cur=cur.left;
        }
        while(!stack.isEmpty()){
            TreeNode ptr=stack.pop();
            c++;
            if(c==k)
                return ptr.val;
            TreeNode rt=ptr.right;
            while(rt!=null){
                stack.push(rt);
                rt=rt.left;
            }
        }
        return 0;
    }


    /*
    iterative, inorder traverse
    time: O(k)
    space: O(k)
    */
    @method3
    public int kthSmallest(TreeNode root, int k) {
        if(root==null)
            return 0;
        Stack<TreeNode> stk=new Stack<TreeNode>();
        ArrayList<Integer> ret=new ArrayList<Integer>();
        while(root!=null||!stk.isEmpty()){
            if(root!=null){
                stk.push(root);
                root=root.left;
            }else{
                root=stk.pop();
                ret.add(root.val);
                if(ret.size()>=k)
                    break;
                root=root.right;
            }
        }
        return ret.get(k-1);
    }
}