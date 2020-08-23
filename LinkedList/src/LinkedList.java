/**
* A single linked-list implementation. This is the most basic data structure and we're
* going to be using it a lot in the upcoming algorithms.
** @author João Vitor Gatti Teixeira, joaogatti17@gmail.com
*
*
*
* */
public class LinkedList {
    /**
     * This is a nested class for representing an Node Object.
     */
    class Node{
        int data;
        Node nxt;

        public Node(int data){
            this.data = data;
            this.nxt = null;
        }
    }

    Node head;

    /**
     *
     * @param data representing the value you want to add in the linked-list.
     *  This method add elements as the first element in the linked-list.
     *  Runs in O(1).
     */
    public void addFront(int data){
        Node temp = new Node(data);
        temp.nxt = head;
        head = temp;
    }

    /**
     *
     * @param data representing the value you want to add in the linked-list.
     *         This method add elements as the last element in the linked-list.
     *         Runs in O(n).
     */
    public void append(int data){
        Node temp = new Node(data);
        Node last = head;
        while(last.nxt != null){
            last = last.nxt;
        }
        last.nxt = temp;

    }

    /**
     * This method traversal the elements in the linked-list,printing its values.
     * Runs in O(n).
     */
    public void printlist(){
        Node tnode = head;
        while(tnode != null){
            System.out.println(tnode.data);
            tnode = tnode.nxt;
        }
    }

    /**
     * This method remove the last element in the linked-list.
     * Runs in O(n).
     */
    public void removelastNode(){
        Node last = head;
        while(last.nxt != null){
            last = last.nxt;
        }


    }

}
