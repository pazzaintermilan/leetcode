/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /*
    time: O(n)
    space: O(1)
    */
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null)
            return null;
        for(RandomListNode cur=head;cur!=null;){
            RandomListNode node=new RandomListNode(cur.label);
            node.next=cur.next;
            cur.next=node;
            cur=node.next;
        }
        for(RandomListNode cur=head;cur!=null;){
            if(cur.random!=null)
                cur.next.random=cur.random.next;
            cur=cur.next.next;
        }
        RandomListNode dummy=new RandomListNode(-1);
        RandomListNode newCur=dummy;
        for(RandomListNode cur=head;cur!=null;){
            newCur.next=cur.next;
            newCur=cur.next;
            cur.next=cur.next.next;
            cur=cur.next;
        }
        return dummy.next;
    }
}