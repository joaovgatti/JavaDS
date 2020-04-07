/*Essa classe eh a responsavel por implementar uma arvore binaria de busca.
Tal implementacao se baseia numa lista encadeada formada por diversos nos,
onde cada no eh formado por uma chave,e uma referencia para cada filho do no(
direito e esquerdo).

Pela propria definicao de um arvore binaria de busca,os metodos basicos para operar
tal estrutura fazem uso de chamadas recursivas.

* */



public class BinarySearchTree {

     Node root;



    //Classe node que representa os nos da arvore.
    private class Node {
        private int key;
        private Node left, right;

        public Node(int key){
            this.key = key;
        }

    }

    //Metodo para buscar um no na arvore.
    public int get(int key) {
        return get(root, key);
    }
    private int get(Node x, int key) {
        if(x == null){
            System.out.println("abb nao existe");
            return 0;
        }else{
            if(key == x.key){
                System.out.println("chave encontrada");
                return x.key;
            }else{
                if(key < x.key){
                    if(x.left == null){
                        System.out.println("chave nao esta na abb");
                        return 0;
                    }else{
                        x = x.left;
                        return get(x,key);
                    }
                }else{
                    if(x.right == null){
                        System.out.println("chave nao esta na abb");
                        return 0;
                    }else{
                        x = x.right;
                        return get(x,key);
                    }
                }
            }
        }
    }


    public int root(Node root){
        return root.key;
    }

    //Metodo para adicionar um elemento na abb
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
        return root;
    }

    //Metodo que retorna o elemento de menor chave
    public int elementoMinimo(Node root){
        return min(root).key;
    }

    private Node min(Node x){
        if(x.left == null) return x;
        return min(x.left);
    }

    public int elementoMaximo(){
        return max(root).key;
    }

    private Node max(Node x){
        if(x.right == null) return x;
        return max(x.right);
    }

    //percurso na arvore
    public void Inorder(){
        Inorder(root);
    }
    private void Inorder(Node root){
        if(root != null){
            Inorder(root.left);
            System.out.println(root.key);
            Inorder(root.right);
        }
    }

    //metodo para deletar um no de forma que a abb
    //continue uma abb
    public void delete(int key){
        root  = deleterec(root,key);

    }
    private Node deleterec(Node root,int key){
        if(root == null) return null;
        if(root.key > key){
            root.left = deleterec(root.left,key);
        }
        else if(root.key < key){
            root.right = deleterec(root.right,key);
        }else{
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            root.key = elementoMinimo(root.right);
            root.right = deleterec(root.right,root.key);
        }
        return root;

    }


   /* Esse metodo eh responsavel por retornar a altura de um abb.
    Recursivamente ele calcula as alturas dos filhos esquerdo e direito
    de cada no,entao ele escolhe o maior e soma um para determinar a sua
    altura.*/

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


    /*Esse eh um metodo simples e ineficiente para testar se um dada
    * arvore binaria eh uma arvore binaria de busca*/
    public boolean isBst(Node root){
       if(root == null) return true;
       if(isSubTreeLesser(root.left,root.key) && isSubTreeGreater(root.right,root.key)
       && isBst(root.left) && isBst(root.right)) return true;
       else{
           return false;
       }
    }

    private boolean isSubTreeLesser(Node root,int value){
       if(root == null) return true;
       if((root.key <= value) &&
           isSubTreeLesser(root.left,value) && isSubTreeLesser(root.right,value)){
           return true;
       }else return false;
    }

    private boolean isSubTreeGreater(Node root,int value){
       if(root == null) return true;
       if((root.key > value) && isSubTreeGreater(root.left,value) && isSubTreeGreater(root.right,value)){
           return true;
       }else return false;
    }

    /*Esse eh um metodo mais eficiente para o teste acima.
    * Em vez de percorrer a arvore varias vezes para testar se os valores
    * sao menores/maiores, ele testa cada no com os limites adequados*/

    public boolean isBstFaster(){
       return isBstUtil(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    private boolean isBstUtil(Node root,int min,int max){
       if(root == null) return true;

       if(root.key < min || root.key > max) return false;

       return (isBstUtil(root.left,min,root.key) && isBstUtil(root.right,root.key,max));

    }



}
