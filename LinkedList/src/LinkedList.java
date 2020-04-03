public class LinkedList {

    class Node{
        int data;
        Node nxt;

        public Node(int data){
            this.data = data;
            this.nxt = null;
        }
    }

    Node head;

    public void addFront(int data){
        Node temp = new Node(data);
        temp.nxt = head;
        head = temp;
    }
    public void append(int data){
        Node temp = new Node(data);
        Node last = head;
        while(last.nxt != null){
            last = last.nxt;
        }
        last.nxt = temp;

    }

    public void printlist(){
        Node tnode = head;
        while(tnode != null){
            System.out.println(tnode.data);
            tnode = tnode.nxt;
        }
    }

    public void removelastNode(){
        Node last = head;
        while(last.nxt != null){
            last = last.nxt;
        }


    }





}
