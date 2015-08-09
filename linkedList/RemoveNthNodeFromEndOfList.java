/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null||n==0)
            return head;
        ListNode dummy=new ListNode(1);
        dummy.next=head;
        ListNode cur=dummy;
        for(int i=0;i<n;i++){
            cur=cur.next;
            if(cur==null)
                return null;
        }
        ListNode pre=dummy;
        while(cur.next!=null){
            pre=pre.next;
            cur=cur.next;
        }
        pre.next=pre.next.next;
        return dummy.next;
    }
}