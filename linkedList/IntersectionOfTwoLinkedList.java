/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /*
    time: O(n)
    space: O(1)
    count the diff of two list length, move largest one forward diff step
    then move two list at the same time to check whether they encounter or not
    */
    @method1
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1=getCount(headA);
        int len2=getCount(headB);
        int diff=Math.abs(len1-len2);
        ListNode cur1=headA,cur2=headB;
        if(len1>len2){
            for(int i=0;i<diff;i++)
                cur1=cur1.next;
        }else{
            for(int i=0;i<diff;i++)
                cur2=cur2.next;
        }
        while(cur1!=null&&cur2!=null){
            if(cur1==cur2)
                return cur1;
            cur1=cur1.next;
            cur2=cur2.next;
        }
        return null;
    }
    
    public int getCount(ListNode head){
        int len=0;
        ListNode cur=head;
        while(cur!=null){
            len++;
            cur=cur.next;
        }
        return len;
    }


    /*
    time: O(n)
    space: O(1)
    Travese the first list and make a circular linked list
    view the problem as find the loop in the second linked list
    */
    @method2
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null)
            return null;
        ListNode cur1=headA;
        ListNode slow=headB,fast=headB;
        while(cur1.next!=null)
            cur1=cur1.next;
        cur1.next=headA;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow)
                break;
        }
        if(fast==null||fast.next==null){
            cur1.next=null;
            return null;
        }
        slow=headB;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        cur1.next=null;
        return slow;
    }
}