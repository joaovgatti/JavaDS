public class Main {

    public static void main(String[] args){
        HashTable table = new HashTable();
        table.add(1,10);
        table.add(2,20);
        table.add(3,30);
        table.add(4,40);
        table.add(12,200);
        table.add(13,300);
        table.add(5,50);
        table.add(15,500);
        table.delete(4);

        System.out.println(table.getValueByKey(4));
    }
}
