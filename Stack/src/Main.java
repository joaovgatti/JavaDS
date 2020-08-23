public class Main {

    public static void main(String[] args){
        Stack pilha = new Stack();
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.push(40);
        pilha.push(50);
        pilha.PrintStack();
        System.out.println("------");
        pilha.pop();
        pilha.pop();
        System.out.println("Depois de duas popadas o elemento no topo agora eh " + pilha.top());
        System.out.println("----");
        pilha.PrintStack();










    }
}
