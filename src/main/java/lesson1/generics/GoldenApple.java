package lesson1.generics;

public class GoldenApple extends Apple{

    private final float weight = 1.0f;

    @Override
    public float getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Golden Apple";
    }
}
