public class Main {

    public static void main(String args[]){
       BinarySearchTree tree = new BinarySearchTree();
       tree.insert(10);
       tree.insert(5);
       tree.insert(15);
       tree.insert(3);
       tree.insert(7);
       tree.insert(13);
       tree.insert(20);
       tree.InOrder(tree.root());



    }
}
