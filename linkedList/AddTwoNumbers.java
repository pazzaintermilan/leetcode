/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(1);
        ListNode cur=dummy;
        int carry=0;
        for(;l1!=null||l2!=null;cur=cur.next){
            int sum=carry;
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            carry=sum/10;
            sum=sum%10;
            ListNode node=new ListNode(sum);
            cur.next=node;
        }
        if(carry!=0)
            cur.next=new ListNode(1);
        return dummy.next;
    }
}