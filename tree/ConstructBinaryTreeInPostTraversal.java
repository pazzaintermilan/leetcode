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
    space: O(logn) or height or tree
    */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
    
    public TreeNode build(int[] inorder,int ibeg,int iend,int[] postorder,int pbeg,int pend){
        if(ibeg>iend||pbeg>pend)
            return null;
        int rootVal=postorder[pend];
        int index=0;
        for(int i=ibeg;i<=iend;i++){
            if(inorder[i]==rootVal){
                index=i;
                break;
            }
        }
        TreeNode root=new TreeNode(rootVal);
        root.left=build(inorder,ibeg,index-1,postorder,pbeg,pbeg+index-ibeg-1);
        root.right=build(inorder,index+1,iend,postorder,pbeg+index-ibeg,pend-1);
        return root;
    }
}