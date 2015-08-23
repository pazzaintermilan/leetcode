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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null||k==0)
            return head;
        int len=1;
        ListNode tail=head,cur=head;
        while(tail.next!=null){
            tail=tail.next;
            len++;
        }
        k=k%len;
        for(int i=0;i<len-k-1;i++)
            cur=cur.next;
        tail.next=head;
        head=cur.next;
        cur.next=null;
        return head;
    }
}