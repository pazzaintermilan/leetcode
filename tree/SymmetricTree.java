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
    space: O(n)
    */
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return isMirror(root.left, root.right);
    }
    
    public boolean isMirror(TreeNode p, TreeNode q){
        LinkedList<TreeNode> queue1 = new LinkedList<TreeNode>();
        LinkedList<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue1.offer(p);
        queue2.offer(q);
        while(!queue1.isEmpty()||!queue2.isEmpty()){
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if(node1==null&&node2==null)
                continue;
            else if(node1==null||node2==null)
                return false;
            else if(node1.val!=node2.val)
                return false;
            queue1.offer(node1.left);
            queue1.offer(node1.right);
            queue2.offer(node2.right);
            queue2.offer(node2.left);
        }
        return true;
    }
}