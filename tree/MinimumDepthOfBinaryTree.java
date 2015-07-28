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
    space: O(n)
    */
    @method1
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        else if(root.left==null)
            return minDepth(root.right)+1;
        else if(root.right==null)
            return minDepth(root.left)+1;
        else
            return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }


    /*
    non-recursive
    time: O(n)
    space: O(n)
    */
    @method2
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        int depth=0;
        while(!queue.isEmpty()){
            depth++;
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
                if(node.left==null&&node.right==null)
                    return depth;
            }
        }
        return depth;
    }
}