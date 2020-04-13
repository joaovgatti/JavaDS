public class Main {

    public static void main(String args[]){
        Avl_tree tree = new Avl_tree();
        tree.insert(10);
        tree.insert(12);
        tree.insert(100);
        tree.insert(1);
        tree.insert(4);
        tree.insert(0);
        System.out.println(tree.root.key);
        tree.preOrder(tree.root);
    }
}
