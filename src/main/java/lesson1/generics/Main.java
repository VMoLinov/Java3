package lesson1.generics;

public class Main {

    public static void main(String[] args) {
        Apple apple = new Apple();
        Orange orange = new Orange();
        GoldenApple goldenApple = new GoldenApple();
        Box<Apple> box1 = new Box<>();
        Box<Apple> box2 = new Box<>();
        Box<Orange> box3 = new Box<>();
        Box<Orange> box4 = new Box<>();
        Box<GoldenApple> box5 = new Box<>();
        Box<Fruit> box6 = new Box();

        box1.addFruit(apple);
        box1.addFruit(apple);
        box3.addFruit(orange);
        box3.addFruit(orange);
        box1.addFruit(apple);
        box5.addFruit(goldenApple);

        System.out.println("box3.compare.box1 is: " + box3.compare(box1));
        box1.removeFruit(apple);

        System.out.println(box1.sumWeight());
        System.out.println(box1.toString());
        System.out.println(box3.toString());
        System.out.println("box3.compare.box1 is: " + box3.compare(box1));

        box1.transfer(box2);
        box3.transfer(box4);
        box5.transfer(box2);
        box2.transfer(box6);

//        box2.transfer(box3); cannot be converted to lesson1.generics.Box<lesson1.generics.Apple>
        System.out.println(box1.toString());
        System.out.println(box2.toString());
        System.out.println(box3.toString());
        System.out.println(box4.toString());
        System.out.println(box5.toString());
        System.out.println(box6.toString());
    }
}
