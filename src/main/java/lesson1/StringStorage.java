//1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
//2. Написать метод, который преобразует массив в ArrayList;
package lesson1;

import java.util.*;

public class StringStorage {

    private String[] data;
    private int currentSize;

    public StringStorage(int size) {
        this.data = new String[size];
    }

    public int getLength() {
        return data.length;
    }

    public void add(String value) {
        add(value, currentSize++);
    }

    public void add(String value, int index) {
        data[index] = value;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public void sort() {
        for (int i = 0, j = 1; j < currentSize; i++, j++) {
            String a = data[i];
            String b = data[j];
            if (a.compareTo(b) > 0) {
                moveItems(i, j);
            }
        }
    }

    private void moveItems(int i, int j) {
        String temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    @Override
    public String toString() {
        return "IntStorage{" +
                "data=" + Arrays.toString(data) +
                '}';
    }

    public ArrayList arrayToArrayList() {
        ArrayList<String> strings = new ArrayList<>();
        for (String string : data) {
            strings.add(string);
        }
        return strings;
    }
}
