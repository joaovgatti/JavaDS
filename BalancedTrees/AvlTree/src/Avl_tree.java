/*Essa eh uma implementacao de uma arvore binaria de busca balanceada do tipo AVL
* Arvores AVL sao aquelas que para qualquer no da arvore a diferenca entre a
* altura das subarvores direita e esquerda eh de no maximo uma unidade.
* Assim,essa arvore mantem o custo de acesso de uma abb otima ( O(log N))
* Para manter essa diferenca sao necessarias operacoes de rotacoes para
* fazer o balanceamento da arvore apos insercoes e remocoes.*/





public class Avl_tree {

    class Node{
        int key;
        int height;
        Node left,right;


        public Node(int key){
            this.key = key;
            //this.height = 1;
        }
    }

     Node root;


    //Esse metodo calcula a altura de um no
    void updateHeight(Node n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    //Get para altura
    int height(Node temp){
        return (temp == null) ? -1 : temp.height;
    }

    //Esse metodo eh responsavel para calcular o fator de balanceamento de um no
    int getBalance(Node temp){
        return (temp == null) ? 0 : height(temp.right) - height(temp.left);
    }

    //Metodo responsavel por fazer a rotacao direita de um no
    //Nao eh a operacao de balanceamento, so de rotacao
    Node rightRot(Node y){
        Node x = y.left;
        Node z = x.right;

        x.right = y;
        y.left = z;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    //Metodo responsavel por fazer a rotacao esquerda de um no
    //Nao eh a operacao de balanceamento, so de rotacao
    Node leftRot(Node y){
        Node x = y.right;
        Node z = x.left;

        x.left = y;
        y.right = z;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    //Esse eh o metodo para realizar o balanceamento de um no desbalenceado.
    Node rebalance(Node z){
        updateHeight(z);
        int balance = getBalance(z);
        //Se o fator de balanceamento for maior que 1, significa que
        //a subarvore direita do no z eh maior que a subarvore esquerda
        if(balance > 1){
            //linha reta na sucessao
            if(height(z.right.right) > height(z.right.left)){
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
            if(height(z.left.left) > height(z.left.right)){
                z = rightRot(z);
            }else{//linha torta
                z.left = leftRot(z.left);
                z = rightRot(z);
            }
        }
        return z;
    }


    //Funcao para inserir um no
    //Funciona como uma insercao normal
    //com o balanceamento
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


    //melhor percurso para ver as rotacoes
    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }


    public int elementoMinimo(Node root){
        if(root.left == null){
            return root.key;
        }else{
            return elementoMinimo(root.left);
        }
    }





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
