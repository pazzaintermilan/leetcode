/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null||head.next==null)
            return head;
        ListNode pre=null;
        ListNode cur=head;
        for(int i=0;i<m-1;i++){
            pre=cur;
            cur=cur.next;
        }
        ListNode q=pre;
        ListNode end=cur;
        pre=cur;
        ListNode p=cur.next;
        for(int i=m;i<n;i++){
            ListNode pNext=p.next;
            p.next=pre;
            pre=p;
            p=pNext;
        }
        end.next=p;
        if(q==null)
            head=pre;
        else
            q.next=pre;
        return head;
    }
}