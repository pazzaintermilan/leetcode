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
    reverse the second half and compare first hard and second harf
    then reverse second half again the link it with first half
    */
    @method1
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null)
            return true;
        ListNode preMid=null;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            preMid=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        if(fast!=null){
            preMid=preMid.next;
            slow=slow.next;
        }
        ListNode secondHalf=reverseList(slow);
        ListNode cur2=secondHalf;
        ListNode cur=head;
        while(cur2!=null){
            if(cur2.val!=cur.val)
                return false;
            cur2=cur2.next;
            cur=cur.next;
        }
        preMid.next=reverseList(secondHalf);
        return true;
    }
    
    public ListNode reverseList(ListNode head){
        if(head==null||head.next==null)
            return head;
        ListNode pre=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }

    /*
    time: O(n)
    space: O(n)
    use stack. Traverse the list twice
    */
    @method2
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null)
            return true;
        Stack<Integer> stk=new Stack<Integer>();
        ListNode cur=head;
        while(cur!=null){
            stk.push(cur.val);
            cur=cur.next;
        }
        cur=head;
        while(cur!=null){
            if(cur.val!=stk.pop())
                return false;
            cur=cur.next;
        }
        return true;
    }
}