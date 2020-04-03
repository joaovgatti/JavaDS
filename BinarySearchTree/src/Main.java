public class Main {

    public static void main(String args[]){
       BinarySearchTree tree = new BinarySearchTree();
       tree.insert(10);
       tree.insert(9);
       tree.insert(8);
       tree.insert(1);
       tree.Inorder();
       System.out.println("--------------");
       tree.delete(8);
       tree.delete(100);
       tree.Inorder();


    }
}
