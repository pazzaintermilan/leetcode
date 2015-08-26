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
    space: height of tree
    */
    @method1
    public int sumNumbers(TreeNode root) {
        if(root==null)
            return 0;
        int[] ret=new int[1];
        sumNumbers(root,ret,0);
        return ret[0];
    }
    
    public void sumNumbers(TreeNode root, int[] ret, int tmp){
        if(root==null)
            return;
        tmp=tmp*10+root.val;
        if(root.left==null&&root.right==null)
            ret[0]+=tmp;
        sumNumbers(root.left,ret,tmp);
        sumNumbers(root.right,ret,tmp);
    }

    /*
    non-recursive
    time: O(n)
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    space: O(logn)
=======
    space: O(n)
>>>>>>> feature
=======
    space: O(n)
>>>>>>> feature
=======
    space: O(n)
>>>>>>> feature
=======
    space: O(n)
>>>>>>> feature
    */
    @method2
    public int sumNumbers(TreeNode root) {
        if(root==null)
            return 0;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        Queue<Integer> sum=new LinkedList<Integer>();
        int res=0;
        queue.offer(root);
        sum.offer(root.val);
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            int tmp=sum.poll();
            if(node.left!=null){
                queue.offer(node.left);
                sum.offer(tmp*10+node.left.val);
            }
            if(node.right!=null){
                queue.offer(node.right);
                sum.offer(tmp*10+node.right.val);
            }
            if(node.left==null&&node.right==null){
                res+=tmp;
            }
        }
        return res;
    }

}