package lesson1;

public class TestStorage {

    public static void main(String[] args) {
        StringStorage data = new StringStorage(10);
        data.add("A");
        data.add("B");
        data.add("C");
        data.add("T");
        data.add("H");
        data.add("W");
        data.add("V");
        data.add("L");

        data.sort();
        System.out.println(data.toString());
        System.out.println(data.getCurrentSize());
        System.out.println(data.getLength());
        System.out.println(data.arrayToArrayList().toString());
    }
}
