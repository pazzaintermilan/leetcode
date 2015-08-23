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
    space: O(1)
    */
    public void reorderList(ListNode head) {
        if(head==null||head.next==null)
            return;
        ListNode pre=null;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            pre=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        pre.next=null;
        slow=reverseList(slow);
        ListNode cur=head;
        while(cur.next!=null){
            ListNode next=slow.next;
            slow.next=cur.next;
            cur.next=slow;
            cur=cur.next.next;
            slow=next;
        }
        cur.next=slow;
    }
    
    public ListNode reverseList(ListNode head){
        if(head==null||head.next==null)
            return head;
        ListNode pre=null,cur=head;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }
}