/**
 * This is the implementation of the Stack ADT using a linked-list.
 * Stack is Lifo - Last in First out - data structure.
 *
 * @author João Vitor Gatti Teixeira, joaogatti17@gmail.com
 */
public class Stack {

    /**
     * This is a nested class representing our Node objects.
     */
    class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
        }
    }
    private Node head;

    /**
     *
     * @param data -> representing the value we want to add in the Stack.
     *  This method add a new element in the stack as the first element.
     *   Runs in O(1).
     */
    public void push(int data){
        Node temp = new Node(data);
        if (!this.isEmpty()) {
            head.next = temp;
        }
        head = temp;
    }

    /**
     * This method removes the last element that was add in the Stack.
     * Runs in O(1).
     */
    public void pop(){
        if(this.isEmpty()){
            System.out.println("Stack is empty.");
        }else head = head.next;
    }

    /**
     *
     * @return true if the stack is empty.
     * Runs in O(1).
     */
    public boolean isEmpty(){
        return head == null;
    }


    /**
     *
     * @return the last element that was add in the stack - the element in the top of the stack.
     * Runs in O(1).
     */
    public int top(){
        if(isEmpty()){
            System.out.println("Stack is empty.");
            return -1;
        }else return (head.data);
    }

    /**
     * This method traversal the elements in the stack printing its values.
     * Runs in O(n).
     */
    public void PrintStack(){
        if(this.isEmpty()){
            System.out.println("Stack is empty.");
        }else {
            Node temp = head;
            while(temp != null){
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }
}
