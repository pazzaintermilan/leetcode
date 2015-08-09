/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode beforeStart=null;
        ListNode beforeEnd=null;
        ListNode afterStart=null;
        ListNode afterEnd=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=null;
            if(cur.val<x){
                if(beforeStart==null){
                    beforeStart=cur;
                    beforeEnd=cur;
                }else{
                    beforeEnd.next=cur;
                    beforeEnd=cur;
                }
            }else{
                if(afterStart==null){
                    afterStart=cur;
                    afterEnd=cur;
                }else{
                    afterEnd.next=cur;
                    afterEnd=cur;
                }
            }
            cur=next;
        }
        if(beforeStart==null)
            return afterStart;
        else{
            beforeEnd.next=afterStart;
            return beforeStart;
        }
    }
}