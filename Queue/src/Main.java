public class Main {


    public static void main(String args[]){

        Queue fila = new Queue();
        fila.enqueue(10);
        fila.printList();
        fila.dequeue();
        fila.printList();
        fila.enqueue(100);
        fila.enqueue(10022);
        fila.printList();
        fila.dequeue();
        fila.printList();
        fila.dequeue();
        fila.printList();

    }


}
