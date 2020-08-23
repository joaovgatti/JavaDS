/**
 This is the implementation of the Dictionary ADT using a Binary Search Tree.
By the definition of an BST, a lot of the methods here uses recursive calls.

@author João Vitor Gatti teixeira, joaogatti17@gmail.com

* */

public class BinarySearchTree {

    /**
     * This is a nested class representing the nodes of a BST.
     */
    private class Node {
        private int key;
        private int info;
        private Node left, right;
        public Node(int key){
            this.key = key;
        }
        public Node(int key,int info){
            this.key = key;
            this.info = info;
        }
    }

    private Node root;

    /**
     *
     * @param key -> is the key to be found in the bst.
     * @return -> if the search is successful returns the value associated with the given key,
     * if the search in not successful returns -1.
     * This method implements the classic search in a BST.
     * Runs in O(log n)/O(n).
     */
    public int get(int key) {
        return get(root, key);
    }
    private int get(Node root, int key) {
        if(root == null){
            System.out.println("BST is empty.");
            return -1;
        }else{
            if(key == root.key){
                System.out.println("key Found.");
                return root.info;
            }else{
                if(key < root.key){
                    if(root.left == null){
                        System.out.println("The key is not in the BST.");
                        return -1;
                    }else{
                        root = root.left;
                        return get(root,key);
                    }
                }else{
                    if(root.right == null){
                        System.out.println("The Key is not in the BST.");
                        return -1;
                    }else{
                        root = root.right;
                        return get(root,key);
                    }
                }
            }
        }
    }

    /**
     *
     *
     * @return the root key of the BST.
     * Runs in O(1).
     */
    public Node root(){
        return this.root;
    }

    /**
     *
     * @param key -> the key to be add in the BST.
     *  This method adds a new element in the bst.
     *   Runs in O(log n)/O(n).
     */
    public void insert(int key){
        root = insert(root,key);
    }
    private Node insert(Node root,int key){
        if(root == null){
            root = new Node(key);
        }else{
            if(root.key > key){
                root.left = insert(root.left,key);

            }else{
                if(root.key < key){
                    root.right = insert(root.right,key);
                }
            }
        }
        return root;
    }

    /**
     *
     * @param root of the BST.
     * @return the minimum element key in the bst.
     * Runs in O(n)/O(log n).
     */
    public int elementoMinimo(Node root){
        if(root.left == null) return root.key;
        return elementoMinimo(root.left);
    }

    /**
     *
     * @param root of the BST.
     * @return the maximum element key in the bst.
     * Runs in O(n)/O(log n).
     */
    public int elementoMaximo(Node root){
       if(root.right == null) return root.key;
       return elementoMaximo(root.right);
    }


    /**
     *
     * @param root of the BST.
     *  This method is the classic InOrder traversal in a bst.
     *  Runs in O(n).
     */
    public void InOrder(Node root){
        if(root != null){
            InOrder(root.left);
            System.out.println(root.key);
            InOrder(root.right);
        }
    }

    /**
     *
     * @param key -> The key associated with the node we want delete.
     * This method deletes a Node in the bst.
     */
    public void delete(int key){
        root  = deleteAux(root,key);
    }
    private Node deleteAux(Node root,int key){
        if(root == null) return null;
        if(root.key > key){
            root.left = deleteAux(root.left,key);
        }
        else if(root.key < key){
            root.right = deleteAux(root.right,key);
        }else{
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }
            root.key = elementoMinimo(root.right);
            root.right = deleteAux(root.right,root.key);
        }
        return root;
    }

    /**
     *
     * @return the height of the bst.
     */
    public int bstHeight(){
        return height(root);
    }
    private int height(Node root){
        if(root == null) return 0;
        else{
            int lefheight = height(root.left);
            int rightheight = height(root.right);

            if(lefheight > rightheight){
                return lefheight + 1;
            }else return rightheight + 1;
        }
    }
}
