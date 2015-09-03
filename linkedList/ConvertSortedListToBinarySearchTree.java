/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    top-down
    time: O(nlogn)
    space: O(logn)
    */
    @method1
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
            return null;
        if(head.next==null)
            return new TreeNode(head.val);
        ListNode pre=null;
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            pre=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        pre.next=null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }

    /*
    bottom up. Implemented in C++ because Java doesn't have pointer and it's copied by value
    time: O(n)
    space: O(logn)
    */
    @method2
    public TreeNode sortedListToBST(ListNode head){
        
    }
}