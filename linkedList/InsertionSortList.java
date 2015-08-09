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
    time: O(n^2)
    space: O(1)
    */
    public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode dummy=new ListNode(Integer.MIN_VALUE);
        ListNode cur=head,pre=dummy;
        while(cur!=null){
            ListNode next=cur.next;
            while(pre.next!=null&&pre.next.val<cur.val)
                pre=pre.next;
            cur.next=pre.next;
            pre.next=cur;
            cur=next;
            pre=dummy;
        }
        return dummy.next;
    }
}