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
    space: O(n^2)
    */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret=new ArrayList<List<Integer>>();
        if(root==null)
            return ret;
        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> list=new ArrayList<Integer>();
            TreeNode lastNode=queue.getLast();
            while(queue.peek()!=lastNode){
                TreeNode curNode=queue.poll();
                if(curNode.left!=null)
                    queue.offer(curNode.left);
                if(curNode.right!=null)
                    queue.offer(curNode.right);
                list.add(curNode.val);
            }
            if(lastNode.left!=null)
                queue.offer(lastNode.left);
            if(lastNode.right!=null)
                queue.offer(lastNode.right);
            list.add(lastNode.val);
            ret.add(0,list);
            queue.poll();
        }
        return ret;
    }
}