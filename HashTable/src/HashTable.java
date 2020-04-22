import java.util.ArrayList;


public class HashTable<K,V> {

    class HashNode<K,V>{

        K key;
        V value;
        HashNode<K,V> next;

        public HashNode(K key,V value){
            this.key = key;
            this.value = value;
        }

    }

    private ArrayList<HashNode<K,V>> bucketarray;

    private int numBuckets;
    private int size1;

    public HashTable(){
        bucketarray = new ArrayList<>();
        size1 = 0;
        numBuckets = 10;
        for(int i=0;i<numBuckets;i++){
            bucketarray.add(null);
        }
    }

    public int getSize(){
        return size1;
    }


    public int getIndex(K key) {
        int cod =   key.hashCode();
        int index =  cod % numBuckets;
        return index;
    }

    public V getValue(K key){
        int bucktetIndex = getIndex(key);
        HashNode<K,V> head = bucketarray.get(bucktetIndex);
        while(head != null){
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }
        return null;
    }


    public void add(K key,V value){
        int bucketIndex = getIndex(key);
        HashNode<K,V> head = bucketarray.get(bucketIndex);
        while(head != null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }
        size1++;
        head = bucketarray.get(bucketIndex);
        HashNode<K,V> temp = new HashNode<K,V>(key, value);
        temp.next = head;
        bucketarray.set(bucketIndex,temp);

    }

    public V delete(K key){
        int bucketIndex = getIndex(key);
        HashNode<K,V> head = bucketarray.get(bucketIndex);
        HashNode<K,V> prev = null;
        while(head != null){
            if(head.key.equals(key)){
                break;
            }
            prev = head;
            head = head.next;
        }
        if(head == null) return null;
        size1--;
        if(prev != null) {
            prev.next = head.next;
        }else{
            bucketarray.set(bucketIndex,head);
        }
        return head.value;
    }














}
