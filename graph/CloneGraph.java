/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node==null)
            return null;
        HashMap<Integer, UndirectedGraphNode> map=new HashMap<Integer, UndirectedGraphNode>();
        LinkedList<UndirectedGraphNode> queue=new LinkedList<UndirectedGraphNode>();
        queue.offer(node);
        UndirectedGraphNode curNode=null;
        //FIFO
        while(!queue.isEmpty()) {
            curNode = queue.poll();
            if (!map.containsKey(curNode.label))
                map.put(curNode.label, new UndirectedGraphNode(curNode.label));
            if (curNode.neighbors!=null) {
                for (UndirectedGraphNode neighbor : curNode.neighbors) {
                    if (!map.containsKey(neighbor.label)) {
                        queue.offer(neighbor);
                        map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                    }
                    map.get(curNode.label).neighbors.add(map.get(neighbor.label));
                }
            }
        }
        return map.get(node.label);
    }
}