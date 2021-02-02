package lesson1;

public class TestStorage {

    public static void main(String[] args) {
        IntStorage data = new IntStorage(10);
        data.add(2);
        data.add(4);
        data.add(8);
        data.add(1);
        data.add(5);
        data.add(9);
        data.add(3);
        data.add(1);

        data.sort();

        System.out.println(data.toString());
        System.out.println(data.getCurrentSize());
        System.out.println(data.getLength());
    }
}
