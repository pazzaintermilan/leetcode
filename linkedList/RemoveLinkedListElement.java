/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /*
    time: O(n)
    space O(1)
    */
    public ListNode removeElements(ListNode head, int val) {
        if(head==null)
            return null;
        ListNode dummy=new ListNode(1);
        dummy.next=head;
        ListNode pre=dummy,cur=head;
        while(cur!=null){
            if(cur.val==val)
                pre.next=cur.next;
            else
                pre=cur;
            cur=cur.next;
        }
        return dummy.next;
    }
}