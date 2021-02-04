package lesson1.generics;

public class Orange extends Fruit {

    private final String NAME = "Апельсин";
    private final float weight = 1.5f;

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
        return "Orange";
    }
}