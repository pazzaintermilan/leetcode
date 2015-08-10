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
    level order traversal. Exceed time limit
    time: O(n)
    space: O(logn)
    */
    @method1
    public int countNodes(TreeNode root) {
        int ret=0;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        while(queue.peek()!=null){
            int size=queue.size();
            ret+=size;
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
    time：O(logn)
    space: O(1)
    */
    public int countNodes(TreeNode root) {
        if(root==null)
            return 0;
        int ret=0;
        int h1=leftH(root.left);
        while(root!=null){
            int h2=leftH(root.right);
            if(h1==h2)
                root=root.right;
            else
                root=root.left;
            ret+=1<<h2;
            h1--;
        }
        return ret;
    }
    
    private int leftH(TreeNode cur){
        int h=0;
        while(cur!=null){
            cur=cur.left;
            h++;
        }
        return h;
    }
    
}