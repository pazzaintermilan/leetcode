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
    time: n
    space: C
    */
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode pre = dummy, cur=head;
        while(cur!=null&&cur.next!=null){
            if(cur.next.val==cur.val){
                while(cur.next!=null&&cur.next.val==cur.val)
                    cur=cur.next;
                pre.next=cur.next;
            }else
                pre=cur;
            cur=cur.next;
        }
        return dummy.next;
    }
}