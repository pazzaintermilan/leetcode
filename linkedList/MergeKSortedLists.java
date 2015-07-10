/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    @method1
    /*
    time: nlogK
    space: logK
    */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        else if(lists.length==1)
            return lists[0];
        else if(lists.length==2)
            return mergeTwoLists(lists[0],lists[1]);
        else
            return mergeTwoLists(mergeKLists(Arrays.copyOfRange(lists,0,lists.length/2)),
                mergeKLists(Arrays.copyOfRange(lists,lists.length/2,lists.length)));
    }
    
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


    @method2
    /*
    time: nlogK
    space: n
    */
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists==null||lists.size()==0)
            return null;
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else
                    return 1;
            }
        });
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);
        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;
            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }
}