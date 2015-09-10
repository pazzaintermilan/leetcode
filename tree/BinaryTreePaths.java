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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret=new ArrayList<String>();
        int height=getHeight(root);
        int[] path=new int[height];
        helper(root,ret,path,0);
        return ret;
    }
    
    private void helper(TreeNode root,List<String> ret,int[] path,int level){
        if(root==null)
            return;
        path[level]=root.val;
        if(root.left==null&&root.right==null){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<level;i++)
                sb.append(path[i]+"->");
            sb.append(path[level]);
            String str=new String(sb);
            ret.add(str);
        }
        helper(root.left,ret,path,level+1);
        helper(root.right,ret,path,level+1);
    }
    
    private int getHeight(TreeNode root){
        if(root==null)
            return 0;
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }

    /*
    recursive
    time: O(n)
    space: height of tree
    */
    @method2
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret=new ArrayList<String>();
        List<Integer> list=new ArrayList<Integer>();
        dfs(root,ret,list);
        return ret;
    }
    
    private void dfs(TreeNode root, List<String> ret, List<Integer> list){
        if(root==null)
            return;
        list.add(root.val);
        if(root.left==null&&root.right==null){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<list.size()-1;i++)
                sb.append(list.get(i)+"->");
            sb.append(list.get(list.size()-1));
            ret.add(String.valueOf(sb));
        }
        dfs(root.left,ret,list);
        dfs(root.right,ret,list);
        list.remove(list.size()-1);
    }

    /*
    recursive
    time: O(n)
    space: height of tree
    */
    @method3
    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null)
            return new ArrayList<String>();
        List<String> returnList = new ArrayList<String>();
        getBinaryTreePaths(returnList,root,"");
        return returnList;
    }

    private void getBinaryTreePaths(List<String> returnList, TreeNode node,String base) {
        String current = base.length()==0?node.val+"":base+"->"+node.val;
        if(node.left == null && node.right == null)
            returnList.add(current);
        if (node.left != null)
            getBinaryTreePaths(returnList,node.left,current);
        if (node.right != null)
            getBinaryTreePaths(returnList,node.right,current);
    }


    /*
    time: O(n)
    space: O(n)
    */
    @method4
    public List<String> binaryTreePaths(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        Queue<String> strs=new LinkedList<String>();
        List<String> ret=new ArrayList<String>();
        if(root!=null){
            queue.offer(root);
            strs.offer(Integer.toString(root.val));
        }
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(node.left==null&&node.right==null){
                ret.add(strs.poll());
            }else{
                String tmp=strs.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                    strs.offer(tmp+"->"+node.left.val);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                    strs.offer(tmp+"->"+node.right.val);
                }
            }
        }
        return ret;
    }

}