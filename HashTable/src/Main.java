public class Main {

    public static void main(String[] args){
        HashTable<Integer,String> map = new HashTable<>();
        map.add(20,"fuck");
        map.add(50,"john");
        map.add(90,"hello");
        map.delete((90));
        map.delete(20);
        System.out.println(map.getValue(20));
        System.out.println(map.getSize());
    }
}
