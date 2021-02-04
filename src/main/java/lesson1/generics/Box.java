package lesson1.generics;

import java.util.Arrays;

public class Box<E> {

    private E[] data;
    private float weight;
    private int currentSize;


    public Box(int size, float weight) {
        data = (E[]) new Object[size];
        this.weight = weight;
        currentSize = 0;
    }

    public void addFruit(E value) {
        addFruit(currentSize++, value);
    }

    private void addFruit(int index, E value) {
        data[index] = value;
    }

    public void removeFruit() {
        data[currentSize-- - 1] = null;
    }
    
    public float sumWeight() {
        return weight * (currentSize);
    }

    public boolean compare (Box value) {
        return this.sumWeight() == value.sumWeight();
    }

    @Override
    public String toString() {
        return "Box{" + Arrays.toString(data) +
                ", currentSize = " + currentSize +
                '}';
    }
}
