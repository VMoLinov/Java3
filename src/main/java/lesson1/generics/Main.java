package lesson1.generics;

public class Main {

    public static void main(String[] args) {
        Apple apple = new Apple();
        Orange orange = new Orange();
        Box<Apple> box1 = new Box(5, 1.0f);
        Box<Orange> box2 = new Box(5, 1.5f);
        Box<Apple> box3 = new Box(5, 1.0f);
        Box<Orange> box4 = new Box(5, 1.5f);

        box1.addFruit(apple);
        box1.addFruit(apple);
        box2.addFruit(orange);
        box2.addFruit(orange);
        box1.addFruit(apple);
//        box1.removeFruit();

        System.out.println("Box1 weight: " + box1.sumWeight());


        System.out.println(box1.toString());
        System.out.println(box2.toString());
        System.out.println(box2.compare(box1));
    }
}
