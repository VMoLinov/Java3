package lesson1.generics;

import java.util.ArrayList;

public class Box<E extends Fruit> {

    private ArrayList<E> data;

    public Box() {
        data = new ArrayList<>();
    }

    public void addFruit(E value) {
        data.add(value);
    }

    public void removeFruit(E value) {
        data.remove(value);
    }

    public float sumWeight() {
        if (!data.isEmpty()) {
            for (E fruit : data) {
                return fruit.getWeight() * data.size();
            }
        }
        return 0;
    }

    public boolean compare(Box<?> box) {
        return this.sumWeight() == box.sumWeight();
    }

    public void transfer(Box<E> box) {
        for (E item : data) {
            box.addFruit(item);
        }
        data.clear();
    }

    @Override
    public String toString() {
        return "Box{" +
                "data=" + data +
                '}';
    }
}
