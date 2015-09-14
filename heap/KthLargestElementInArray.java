import java.util.Comparator;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>(){
           public int compare(Integer o1, Integer o2){
               return o1-o2;
           } 
        });
        for(int val: nums){
            if(queue.size()<k)
                queue.offer(val);
            else{
                if(val>queue.peek()){
                    queue.poll();
                    queue.offer(val);
                }
            }
        }
        return queue.peek();
    }
}