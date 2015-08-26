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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    space: O(logn)
=======
    space: height of tree 
>>>>>>> feature
=======
    space: height of tree 
>>>>>>> feature
=======
    space: height of tree 
>>>>>>> feature
=======
    space: height of tree 
>>>>>>> feature
    */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret=new ArrayList<List<Integer>>();
        List<Integer> list=new ArrayList<Integer>();
        pathSum(root,sum,list,ret);
        return ret;
    }
    
    private void pathSum(TreeNode node, int tmpSum, List<Integer> list, List<List<Integer>> ret){
        if(node==null)
            return;
        list.add(node.val);
        if(node.left==null&&node.right==null){
            if(tmpSum==node.val){
                List<Integer> tmp=new ArrayList<Integer>(list);
                ret.add(tmp);
            }
        }
        pathSum(node.left,tmpSum-node.val,list,ret);
        pathSum(node.right,tmpSum-node.val,list,ret);
        list.remove(list.size()-1);
    }
}