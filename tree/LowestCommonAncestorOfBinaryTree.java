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
    space: O(logn) or height of tree
    */
    @method1
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q)
            return root;
        else {
            TreeNode leftAncester = lowestCommonAncestor(root.left, p, q);
            TreeNode rightAncester = lowestCommonAncestor(root.right, p, q);
            if(leftAncester!=null&&rightAncester!=null)
                return root;
            else
                return leftAncester!=null?leftAncester:rightAncester;
        }
    }

    /*
    recursive
    time: O(n)
    space: height of tree
    */
    @method2
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = new ArrayList<TreeNode>();
        List<TreeNode> path2 = new ArrayList<TreeNode>();
        if(!findPath(root,path1,p)||!findPath(root,path2,q))
            return null;
        TreeNode ret=null;
        int i=0;
        for(;i<path1.size()&&i<path2.size();i++)
            if(path1.get(i)!=path2.get(i))
                break;
        return path1.get(i-1);
    }
    
    public boolean findPath(TreeNode root, List<TreeNode> path, TreeNode node){
        if(root==null)
            return false;
        path.add(root);
        if(root==node)
            return true;
        if((root.left!=null&&findPath(root.left,path,node))
            ||(root.right!=null&&findPath(root.right,path,node)))
            return true;
        path.remove(path.size()-1);
        return false;
    }
}