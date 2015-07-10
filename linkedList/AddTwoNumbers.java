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
    time: n
    space: C
    */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode cur=dummy;
        int carry=0;
        while(l1!=null||l2!=null){
            int sum=carry;
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            carry = sum/10;
            cur.next=new ListNode(sum%10);
            cur=cur.next;
        }
        if(carry!=0)
            cur.next=new ListNode(1);
        return dummy.next;
    }
}