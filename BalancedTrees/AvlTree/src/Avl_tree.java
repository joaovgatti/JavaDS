/*
    This is the implementation of the Dictionary ADT using an AVL BST.
    Avl tree is a balanced bst - the difference of heights between the left and right
    subtree is no greater than one, for every node in the Tree. This property guarantee
    that basic operations takes O(log n).
 */
public class Avl_tree {


    /**
     * This is a nested class for representing a Node Object.
     */
    class Node{
        int key;
        int height;
        Node left,right;

        public Node(int key){
            this.key = key;

        }
    }

     Node root;


    /**
     *
     * @param n -> A Node n.
     * This method updates the height of a Node.
     */
    void updateHeight(Node n) {
        n.height = 1 + Math.max(getHeight(n.left), getHeight(n.right));
    }

    /**
     *
     * @param temp -> A node Temp
     * @return the height of a node.
     */
    int getHeight(Node temp){
        return (temp == null) ? -1 : temp.height;
    }

    /**
     *
     * @param temp -> A node temp
     * @return  the the balance factor.
     */
    int getBalance(Node temp){
        return (temp == null) ? 0 : getHeight(temp.right) - getHeight(temp.left);
    }

    /**
     *
     * @param temp -> A node temp
     * @return right rotation.
     * This method is responsible for doing a right rotation.
     */
    Node rightRot(Node temp){
        Node x = temp.left;
        Node z = x.right;

        x.right = temp;
        temp.left = z;

        updateHeight(temp);
        updateHeight(x);

        return x;
    }

    /**
     *
     * @param temp -> A node temp
     * @return left rotation.
     * This method is responsible for doing a left rotation.
     */
    Node leftRot(Node temp){
        Node x = temp.right;
        Node z = x.left;

        x.left = temp;
        temp.right = z;

        updateHeight(temp);
        updateHeight(x);

        return x;
    }

    /**
     *
     * @param z -> A node Z
     * @return z rebalanced.
     * This method uses the leftRotation e rightRotation to rebalance a Node.
     */
    Node rebalance(Node z){
        updateHeight(z);
        int balance = getBalance(z);
        //Se o fator de balanceamento for maior que 1, significa que
        //a subarvore direita do no z eh maior que a subarvore esquerda
        if(balance > 1){
            //linha reta na sucessao
            if(getHeight(z.right.right) > getHeight(z.right.left)){
                z = leftRot(z);
            //linha torta
            }else{
                z.right = rightRot(z.right);
                z = leftRot(z);
            }
        //se o fator de balanceamento for menor do q -1,significa que
        // a subavore esquerda eh maior que a subarvore direita
        }else if(balance < -1){
            //linha reta
            if(getHeight(z.left.left) > getHeight(z.left.right)){
                z = rightRot(z);
            }else{//linha torta
                z.left = leftRot(z.left);
                z = rightRot(z);
            }
        }
        return z;
    }


    /**
     *
     * @param key to be add.
     * This method add an element in the bst, using the rebalance method.
     */
    public void insert(int key){
        root = insert(root,key);
    }
    private Node insert(Node root,int key){
        if(root == null){
            root = new Node(key);
            return root;
        }else{
            if(root.key > key){
                root.left = insert(root.left,key);

            }else{
                if(root.key < key){
                    root.right = insert(root.right,key);
                }
            }
        }
        return rebalance(root);
    }


    /**
     *
     * @param temp -> A node temp.
     * PreOrder traversals in the tree.
     */
    void preOrder(Node temp) {
        if (temp != null) {
            System.out.print(temp.key + " ");
            preOrder(temp.left);
            preOrder(temp.right);
        }
    }

    /**
     *
     * @param root -> Node root.
     * @return the minimum element of the subtree with Root root.
     */
    public int elementoMinimo(Node root){
        if(root.left == null){
            return root.key;
        }else{
            return elementoMinimo(root.left);
        }
    }


    /**
     *
     * @param key to be Deleted.
     * @return the node deleted.
     */
    public Node delete(int key){
       return  deleteUtil(root,key);
    }

    private Node deleteUtil(Node root,int key){
        if(root == null) return null;
        else if(root.key > key){
            root.left = deleteUtil(root.left,key);
        }else if(root.key < key){
            root.right = deleteUtil(root.right,key);
        }else{
            if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            }
            root.key = elementoMinimo(root.right);
            root.right = deleteUtil(root.right,root.key);

        }
        if(root != null){
            root = rebalance(root);
        }
        return root;
    }





















































}
