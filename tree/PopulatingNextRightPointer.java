/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
	/*
	recursive
	time: O(n)
	space: height of tree
	*/
	@method1
    public void connect(TreeLinkNode root) {
        if(root==null||root.left==null)
            return;
        root.left.next=root.right;
        if(root.next!=null)
            root.right.next=root.next.left;
        connect(root.left);
        connect(root.right);
    }

    /*
	non-recursive
	time: O(n)
	space: O(logn)
    */
    @method2
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> queue=new LinkedList<TreeLinkNode>();
        queue.offer(root);
        while(queue.peek()!=null){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeLinkNode node=queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                    node.left.next=node.right;
                }
                if(node.right!=null){
                    queue.offer(node.right);
                    if(node.next!=null)
                        node.right.next=node.next.left;
                }
            }
        }
    }
}