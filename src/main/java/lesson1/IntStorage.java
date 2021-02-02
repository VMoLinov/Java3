//1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
//2. Написать метод, который преобразует массив в ArrayList;
//3. Задача:
//Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
//Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну коробку
// нельзя сложить и яблоки, и апельсины;
//Для хранения фруктов внутри коробки можно использовать ArrayList;
//Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество: вес яблока – 1.0f,
//апельсина – 1.5f (единицы измерения не важны);
//Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую подадут в
//compare() в качестве параметра. true – если их массы равны, false в противоположном случае. Можно сравнивать коробки
//с яблоками и апельсинами;
//Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую. Помним про сортировку фруктов:
//нельзя яблоки высыпать в коробку с апельсинами. Соответственно, в текущей коробке фруктов не остается, а в другую
//перекидываются объекты, которые были в первой;
//Не забываем про метод добавления фрукта в коробку.
package lesson1;

public class IntStorage {

    private int[] data;
    private int currentSize;

    public IntStorage(int size) {
        this.data = new int[size];
    }

    public int getLength() {
        return data.length;
    }

    public int get(int index) {
        return data[index];
    }

    public void add(int value) {
        add(value, currentSize);
    }

    public void add(int value, int index) {
        data[index] = value;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public void sort() {
        for (int i = 0, j = 1; j < data.length; i++) {
            if (data[j] != 0 && data[i] > data[j]) {
                moveItems(i, j);
            }
        }
    }

    private void moveItems(int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
