public class Queue {


    private class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
        }
    }

    private Node head;
    private Node last;

    public boolean isEmpty(){
        return head == null;
    }


    public void enqueue(int data){
        Node temp = new Node(data);
        Node     lastOld = last;
        last = temp;
        last.next = null;
        if(isEmpty()) head = last;
        else lastOld.next = last;
    }

    public void dequeue(){
        Node temp = head;
        head = head.next;
        System.out.println("desqueuei");
        if(isEmpty()){
            last = null;
        }

    }

    public void printList(){
        Node temp  = head;
        if(temp == null){
            System.out.println("lista vazia");
        }
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }


}
