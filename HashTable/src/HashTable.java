/**
 * This is the implementation of a Dictionary ADT using a hashTable.
 * HashTables basic operations runs in O(1) in the average case.
 * @author João Vitor Gatti Teixeira, joaogatti17@gmail.com
 */
import java.util.ArrayList;


public class HashTable{
    /**
     * This is a nested class for representing a Node object.
     */
    class Node{
        int key;
        int value;
        Node next;

        public Node(int k,int v){
            this.key = k;
            this.value = v;
        }
    }

    private ArrayList<Node> bucketTable;
    private int numBuckets;
    private int size;

    /**
     * This is our constructor for the HashTables. Note that the underlying structure for our HashTable is
     * an ArrayList of Nodes.
     */
    public HashTable(){
        numBuckets = 10;
        size = 0;
        bucketTable = new ArrayList<>();
        for(int i=0;i<numBuckets;i++){
            bucketTable.add(null);
        }
    }

    /**
     *
     * @return the number of elements in the table.
     */
    public int getSize(){
        return this.size;
    }

    /**
     *
     * @return true if the table is empty.
     */
    public boolean isEmpty(){
        return(getSize() == 0);
    }

    /**
     *
     * @param key -> the key of our node objects.
     * @return the HashCodeIndex of our table.
     * This is our HashFunction. Its responsible for compute the index
     * of our table accordingly the given key.
     */
    private int getHashCodeIndex(int key){
        return key % numBuckets;
    }

    /**
     *
     * @param key to be add.
     * @param value to be add.
     * This method is responsible for add pairs of Key-Value in our table.
     */
    public void add(int key,int value){
        Node temp = new Node(key,value);
        Node head = bucketTable.get(getHashCodeIndex(key));
        temp.next = head;
        bucketTable.set(getHashCodeIndex(key),temp);
        size++;
    }

    /**
     *
     * @param key associated to the value to be deleted.
     * @return the value associated with the given Key. Return -1 if the element is not in the table.
     * This method deletes a value in our table.
     */
    public int delete(int key){
        int index = getHashCodeIndex(key);
        Node head = bucketTable.get(index);
        Node prev = null;
        while(head != null){
            if(head.key == key){
                break;
            }
            prev = head;
            head = head.next;
        }
        if(head == null){
            System.out.println("Key is not in the Table");
            return -1;
        }
        if(prev != null){
            prev.next = head.next;
        }else{
            bucketTable.set(index,head.next);
        }
        size--;
        return head.value;
    }

    /**
     *
     * @param key associated to the value to be get.
     * @return the value associated with the Given Key. Return -1 if the element is not in the table.
     */
    public int getValueByKey(int key){
        int index = getHashCodeIndex(key);
        Node head = bucketTable.get(index);
        while(head != null){
            if(head.key == key){
                return head.value;
            }
            head = head.next;
        }
        System.out.println("key not in the table.");
        return -1;

    }
}
