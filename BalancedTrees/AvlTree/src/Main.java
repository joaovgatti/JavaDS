public class Main {

    public static void main(String args[]){
        Avl_tree tree = new Avl_tree();
        tree.insert(9);
        tree.insert(5);
        tree.insert(10);
        tree.insert(0);
        tree.insert(6);
        tree.insert(11);
        tree.insert(-1);
        tree.insert(1);
        tree.insert(2);
        //tree.preOrder(tree.root);
        tree.root = tree.delete(10);
        System.out.println(tree.root.key);
        tree.preOrder(tree.root);
    }
}
