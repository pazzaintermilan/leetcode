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
    time: O
    space: C
    */
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
}