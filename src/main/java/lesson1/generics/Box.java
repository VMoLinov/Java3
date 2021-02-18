package lesson1.generics;

import java.util.ArrayList;
import java.util.Objects;

public class Box<E extends Fruit> {

    private final ArrayList<E> data;

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
            return data.get(0).getWeight() * data.size();
        }
        return 0;
    }

    public boolean compare(Box<?> box) {
        return this.sumWeight() == box.sumWeight();
    }

    public void transfer(Box<? super E> box) {
        box.data.addAll(data);
        data.clear();
    }

    @Override
    public String toString() {
        return "Box{" +
                "data=" + data +
                '}';
    }
}
