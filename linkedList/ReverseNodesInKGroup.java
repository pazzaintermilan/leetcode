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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||head.next==null||k==1)
            return head;
        int len=0;
        ListNode cur=head;
        while(cur!=null){
            len++;
            cur=cur.next;
        }
        if(k>len)
            return head;
        ListNode pre=null;
        cur=head;
        for(int i=0;i<k;i++){
            ListNode pNext=cur.next;
            cur.next=pre;
            pre=cur;
            cur=pNext;
        }
        if(len-k>=k)
            head.next=reverseKGroup(cur,k);
        else
            head.next=cur;
        return pre;
    }
}