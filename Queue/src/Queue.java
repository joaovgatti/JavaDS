/**
* This is the implementation of the Queue ADT using linked-lists.
 * Queue is FiFo ADT.
 * @author João Vitor Gatti Teixeira, joaogatti17@gmail.com
 */


public class Queue {

    /**
     * This is a nested class for representing a Node object.
     */
    private class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
        }
    }

    private Node head;
    private Node last;

    /**
     *
     * @return true if the Queue is empty.
     * Runs in 0(n).
     */
    public boolean isEmpty(){
        return head == null;
    }

    /**
     *
     * @param data representing the value you want to add in the queue.
     *         This method add a new element in the queue as the last element of the queue.
     *         Remember, queue is a FirstInFirstOut data structure.
     *         Runs in O(n).
     *
     */
    public void enqueue(int data){
        Node temp = new Node(data);
        if(this.isEmpty()){
          head = last = temp;
        }else{
            Node lastOld = last;
            last = temp;
            last.next = null;
            lastOld.next = last;
        }
    }

    /**
     * This method remove the first element of the Queue.
     * Runs in O(n).
     */
    public void dequeue(){
        if(this.isEmpty()){
            System.out.println("Queue is already empty");
        }else{
            head = head.next;
        }

    }


    /**
     * This method traversal all the elements in the Queue,printing its values.
     * Runs in O(n).
     */
    public void printList(){
        if(this.isEmpty()){
            System.out.println("lista vazia");
        }else{
            Node temp = head;
            while(temp != null){
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }
}
