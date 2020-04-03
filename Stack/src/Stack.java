public class Stack {

    class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
        }
    }
    Node head;

    public void push(int data){
        Node temp = new Node(data);
        Node aux = head;
        if(head == null){
            head = temp;
        }
        head = temp;
        temp.next = aux;
    }

    public void pop(){
        if(head == null){
            System.out.println("nothing to pop");
            return;
        }
        head = head.next;
    }

    public boolean isEmpty(){
        if(head == null) return true;
        return false;
    }

    public int top(){
        if(isEmpty() == true){
            System.out.println("vazia");
            return Integer.MIN_VALUE;
        }
        else{
            return(head.data);
        }
    }

    public void PrintStack(){
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.data);
            temp  = temp.next;
        }
    }
}
