package lesson5;

import java.util.concurrent.*;

public class Car implements Runnable {
    private static CountDownLatch cdl = new CountDownLatch(MainClass.CARS_COUNT);
    private static CyclicBarrier cb = new CyclicBarrier(MainClass.CARS_COUNT);
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        this.name = "Участник #" + ++CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            if (cb.await() == 0)
                System.out.println(Colours.ANSI_BLUE.getValue() + "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка стартовала!!!" + Colours.ANSI_RESET.getValue());
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        try {
            if (cdl.getCount() == MainClass.CARS_COUNT)
                System.out.println(Colours.ANSI_RED.getValue() + "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> " + name + " Выиграл гонку!!!" + Colours.ANSI_RESET.getValue());
            cdl.countDown();
            if (cdl.getCount() == 0)
                System.out.println(Colours.ANSI_YELLOW.getValue() + "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }
}
