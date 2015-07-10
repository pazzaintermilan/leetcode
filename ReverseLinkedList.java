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
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode pre=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode pNext=cur.next;
            cur.next=pre;
            pre=cur;
            cur=pNext;
        }
        return pre;
    }
}