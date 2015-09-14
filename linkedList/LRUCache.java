public class LRUCache {
    private int capacity;
    private CacheNodeList cacheList;
    private HashMap<Integer, CacheNode> cacheMap;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.cacheList=new CacheNodeList(capacity);
        this.cacheMap=new HashMap<Integer, CacheNode>();
    }

    public int get(int key) {
        CacheNode requestNode=cacheMap.get(key);
        if(requestNode==null)
            return -1;
        cacheList.shiftToFirst(requestNode);
        return requestNode.val;
    }

    public void set(int key,int value) {
        if(cacheMap.containsKey(key)){
            CacheNode requestNode=cacheMap.get(key);
            requestNode.val=value;
            cacheList.shiftToFirst(requestNode);
        }
        else{
            if(cacheMap.size()==capacity){
                CacheNode node=cacheList.removeLast();
                cacheMap.remove(node.key);
            }
            CacheNode newCache=new CacheNode(key,value);
            cacheList.insertFirst(newCache);
            cacheMap.put(key,newCache);
        }
    }
}

class CacheNode{
    int key;
    int val;
    CacheNode prev;
    CacheNode next;

    public CacheNode(int key, int val){
        this.key=key;
        this.val=val;
        this.prev=null;
        this.next=null;
    }
}

class CacheNodeList{
    private CacheNode head;
    private CacheNode tail;

    public CacheNodeList(int capacity){
        head=new CacheNode(0,0);
        tail=new CacheNode(0,0);
        head.next=tail;
        tail.prev=head;
    }

    public void insertFirst(CacheNode node){
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
        node.prev=head;
    }

    public CacheNode removeLast(){
        CacheNode lastNode=tail.prev;
        tail.prev=tail.prev.prev;
        tail.prev.next=tail;
        return lastNode;
    }

    public void shiftToFirst(CacheNode node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
        this.insertFirst(node);
    }
}