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
    time: O(nlogn)
    space: O(1)
    */
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode pre=null,slow=head,fast=head;
        while(fast!=null&&fast.next!=null){
            pre=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        pre.next=null;
        head=sortList(head);
        slow=sortList(slow);
        return mergeTwoLists(head,slow);
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode dummy=new ListNode(1);
        for(ListNode cur=dummy;l1!=null||l2!=null;cur=cur.next){
            int val1=l1==null?Integer.MAX_VALUE:l1.val;
            int val2=l2==null?Integer.MAX_VALUE:l2.val;
            if(val1<val2){
                cur.next=l1;
                l1=l1.next;
            }else{
                cur.next=l2;
                l2=l2.next;
            }
        }
        return dummy.next;
    }
}