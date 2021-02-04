package lesson1.generics;

public class Apple extends Fruit {

    private final String NAME = "Яблоко";
    private final float weight = 1.0f;

    @Override
    public float getWeight() {
        return weight;
    }

    @Override
    public String getNAME() {
        return NAME;
    }

    @Override
    public String toString() {
        return "Apple";
    }
}
