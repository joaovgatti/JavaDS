public class Main {

    public static void main(String args[]){
       BinarySearchTree tree = new BinarySearchTree();
       tree.insert(10);
       tree.insert(100);
       tree.insert(9);
       tree.insert(102);
       //System.out.println("a altura eh "+tree.bstHeight());
       System.out.println(tree.isBstFaster());



    }
}
