/*
Esse eh uma implementacao de uma arvore B. Arvores B sao muito uteis para aplicacoes que utilizam
um grande numero de dados.Com tal estrutura podemos diminuir o acesso ao disco ou qualquer outro
tipo de memoria secundaria,gracas ao grande numero de chaves que cada no pode obter assim como
o numero de filhos que cada no pode possuir.




*/

public class Btree {


    //Classe que representa um no de uma arvore B.
    class BtreeNode{
        int numberofKeys;
        int[] keys;
        BtreeNode[] child;
        Boolean leaf;

        //No construtor de um no informa-se eh uma folha e atribui
        //o valor maximo possivel de memoria para o numero de chaves
        //e o numero de filhos.
        public BtreeNode(Boolean leaf){
            this.leaf = leaf;
            keys = new int[2*t-1];
            child = new BtreeNode[2*t];
            numberofKeys = 0;
        }
    }

    //Essa variavel eh reponsavel por informar o grau da arvore B.
    private int t ;
    private BtreeNode root;

    public Btree(int t){
        this.t = t;
        root = null;
    }


    //Esse metodo eh responsavel por dividir um no que esteja lotado,
    //ou seja,numeroDeChaves = 2t-1.
    private void split(BtreeNode x,int i){
        //Cria-se um novo no para armazenar alguns valores do no lotado.
        BtreeNode z = new BtreeNode(x.leaf);
        BtreeNode y = x.child[i];
        z.numberofKeys = t-1;
        for(int j=0;j < t-1;j++){
            z.keys[j] = y.keys[j+t];
        }
        if(!y.leaf){
            for(int j=0;j<t;j++){
                z.child[j] = y.child[j+t];
            }
        }
        y.numberofKeys = t -1;
        for(int j = x.numberofKeys;j>=i+1;j--){
            x.child[j+1] = x.child[j];
        }
        x.child[i+1] = z;
        for(int j = x.numberofKeys-1;j>=i;j--){
            x.keys[j+1] = x.keys[j];
        }
        x.keys[i] = y.keys[t-1];
        x.numberofKeys = x.numberofKeys + 1;
    }

    public void insert(int key){
        if(root == null){
            root = new BtreeNode(true);
            root.keys[0] = key;
            root.numberofKeys = 1;
        }else{
            if(root.numberofKeys == 2*t-1){
                BtreeNode s = new BtreeNode(false);
                root = s;
                s.numberofKeys = 0;
                s.child[0] = root;
                split(s,0);
                insertNonFull(s,key);
            }else{
                insertNonFull(root,key);
            }
        }
    }

    private  void insertNonFull(BtreeNode x,int key){
        int i = x.numberofKeys-1;
        if(x.leaf){
            while(i>=0 && key < x.keys[i]){
                x.keys[i+1] = x.keys[i];
                i--;
            }
            x.keys[i+1] = key;
            x.numberofKeys = x.numberofKeys + 1;
        }else{
            while(i>= 0 && key<x.keys[i]){
                i--;
            }
            if(x.child[i+1].numberofKeys == 2*t-1){
                split(x.child[i+1],i+1);
                if(key > x.keys[i+1]){
                    i++;
                }
            }insertNonFull(x.child[i],key);

        }
    }



    public BtreeNode search(int key){
         return get(root,key);
    }

    private BtreeNode get(BtreeNode temp,int key){
        int i = 0;
        while (i < temp.numberofKeys && key > temp.keys[i]) {
            i++;
        }
        if (i < temp.numberofKeys && key == temp.keys[i]) {
            System.out.println("achou a chave");
            return (temp);
        } else if (temp.leaf) {
            System.out.println("chave nao esta na arvore");
            return null;
        }
        return get(temp.child[i], key);
    }
}





