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
    iterative
    time:O(n)
    space:O(1)
    */
    @method1
    public void recoverTree(TreeNode root) {
        TreeNode[] broken=new TreeNode[2];
        TreeNode pre=null,cur=root;
        while(cur!=null){
            if(cur.left!=null){
                TreeNode tmp=cur.left;
                while(tmp.right!=null&&tmp.right!=cur)
                    tmp=tmp.right;
                if(tmp.right==null){
                    tmp.right=cur;
                    cur=cur.left;
                }else{
                    verify(broken,pre,cur);
                    tmp.right=null;
                    pre=cur;
                    cur=cur.right;
                }
            }else{
                verify(broken,pre,cur);
                pre=cur;
                cur=cur.right;
            }
        }
        int val=broken[0].val;
        broken[0].val=broken[1].val;
        broken[1].val=val;
    }
    
    private void verify(TreeNode[] broken,TreeNode pre,TreeNode cur){
        if(pre!=null&&pre.val>cur.val){
            if(broken[0]==null)
                broken[0]=pre;
            broken[1]=cur;
        }
    }


    /*
    recursive
    time:O(n)
    space:O(n)
    */
    @method2

    TreeNode pre;
    TreeNode node1,node2;   
    public void recoverTree(TreeNode root) {
        if(root==null)
            return;
        recursiveRecover(root);
        if(node1!=null&&node2!=null){
            int val=node1.val;
            node1.val=node2.val;
            node2.val=val;
        }
    }
    
    private void recursiveRecover(TreeNode root){
        if(root==null)
            return;
        recursiveRecover(root.left);
        if(pre!=null&&pre.val>root.val){
            if(node1==null)
                node1=pre;
            node2=root;
        }
        pre=root;
        recursiveRecover(root.right);
    }
}