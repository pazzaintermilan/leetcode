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
    @method1
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret=new ArrayList<List<Integer>>();
        if(root==null)
            return ret;
        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        boolean left=true;
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
            if(left){
                ret.add(list);
                left=false;
            }else{
                ArrayList<Integer> tmp=new ArrayList<Integer>();
                for(int i=list.size()-1;i>=0;i--)
                    tmp.add(list.get(i));
                ret.add(tmp);
                left=true;
            }
            queue.poll();
        }
        return ret;
    }

    /*
    time: O(n)
    space: O(n)
    */
    @method2
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret=new ArrayList<List<Integer>>();
        if(root==null)
            return ret;
        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        boolean left=true;
        while(!queue.isEmpty()){
            List<Integer> list=new ArrayList<Integer>();
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }
            if(left){
                ret.add(list);
                left=false;
            }else{
                ArrayList<Integer> tmp=new ArrayList<Integer>();
                for(int i=list.size()-1;i>=0;i--)
                    tmp.add(list.get(i));
                ret.add(tmp);
                left=true;
            }
        }
        return ret;
    }
}