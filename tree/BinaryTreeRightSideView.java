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
    level order traversal
    time: O(n)
    space: O(logn)
    */
    @method1
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret=new ArrayList<Integer>();
        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        while(queue.peek()!=null){
            int size=queue.size();
            ret.add(queue.getLast().val);
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }
        }
        return ret;
    }

    /*
    DFS
    time: O(n)
    space: O(height of tree)
    */
    @method2
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result=new ArrayList<Integer>();
        help(root,1,result);
        return result;
    }
    
    public void help(TreeNode root, int depth, List<Integer> result){
        if(root==null) 
            return;
        if(result.size()<depth) 
            result.add(root.val);
        help(root.right,depth+1,result);
        help(root.left,depth+1,result);
    }
}