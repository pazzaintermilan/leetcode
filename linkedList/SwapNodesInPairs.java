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
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode pPre=null;
        ListNode pre=null;
        ListNode cur=head;
        while(cur!=null&&cur.next!=null){
            pre=cur;
            cur=cur.next;
            ListNode pNext=cur.next;
            if(pPre!=null)
                pPre.next=cur;
            else
                head=cur;
            cur.next=pre;
            pre.next=pNext;
            pPre=pre;
            cur=pNext;
        }
        return head;
    }
}