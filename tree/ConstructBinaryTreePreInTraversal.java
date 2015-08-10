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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    
    public TreeNode build(int[] preorder,int pbeg,int pend,int[] inorder,int ibeg,int iend){
        if(pbeg>pend||ibeg>iend)
            return null;
        int rootVal=preorder[pbeg];
        int index=0;
        for(int i=ibeg;i<=iend;i++){
            if(inorder[i]==rootVal){
                index=i;
                break;
            }
        }
        TreeNode root=new TreeNode(rootVal);
        root.left=build(preorder,pbeg+1,pbeg+index-ibeg,inorder,ibeg,index-1);
        root.right=build(preorder,pbeg+index-ibeg+1,pend,inorder,index+1,iend);
        return root;
    }
}