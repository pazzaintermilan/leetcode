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
    time: O(m+n)
    space: O(1)
    */
    @method1
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(1);
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

    /*
    time: O(min(m,n))
    space: O(1)
    */
    @method2
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        ListNode dummy=new ListNode(-1);
        ListNode cur=dummy;
        for(;l1!=null&&l2!=null;cur=cur.next){
            if(l1.val<l2.val){
                cur.next=l1;
                l1=l1.next;
            }else{
                cur.next=l2;
                l2=l2.next;
            }
        }
        cur.next=l1==null?l2:l1;
        return dummy.next;
    }
}