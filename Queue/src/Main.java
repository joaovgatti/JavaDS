public class Main {


    public static void main(String args[]){

        Queue fila = new Queue();
        fila.enqueue(10);
        fila.enqueue(20);
        fila.enqueue(30);
        fila.enqueue(40);
        fila.enqueue(50);
        fila.printList();
        System.out.println("--------");
        fila.dequeue();
        fila.printList();
        System.out.println("--------");
        fila.enqueue(100);
        fila.printList();


    }


}
