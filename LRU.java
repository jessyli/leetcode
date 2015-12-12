

public class LRUCache {
    public class Node{
        int val;
        int key;
        Node pre;
        Node next;
        public Node(int key,int val){
            this.val = val;
            this.key = key;
        }
    }
    int capacity;
    Node head;
    Node end;
    HashMap<Integer, Node> hm = new HashMap<Integer, Node>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = null;
        this.end = null;
    }
    
    public int get(int key) {
        if(hm.containsKey(key)){
            Node temp = hm.get(key);
            remove(temp);
            sethead(temp);
            return temp.val;
        }
        else{
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if(hm.containsKey(key)){
            Node temp = hm.get(key);
            
            temp.val = value;
            remove(temp);
            sethead(temp);
        }
        else if(!hm.containsKey(key)&&hm.size()<capacity){
            Node temp = new Node(key, value);
            sethead(temp);
            hm.put(key, temp);
        }
        else{
            Node temp = new Node(key, value);
            hm.remove(end.key);
            remove(end);
            sethead(temp);
            hm.put(key, temp);
        }
    }
    
    public void remove(Node temp){
        if(temp.next!=null){
            temp.next.pre = temp.pre;
        }
        else{
            end = temp.pre;
        }
        
        if(temp.pre!=null){
            temp.pre.next = temp.next;
        }
        else{
            head = temp.next;
        }
    }
    
    public void sethead(Node temp){
        temp.next = head;
        temp.pre = null;
        if(head!=null){
            head.pre = temp;
        }
        head = temp;
        if(end==null){
            end = head;
        }
       
    }
}
