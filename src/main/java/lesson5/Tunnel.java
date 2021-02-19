package lesson5;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    Semaphore smp = new Semaphore(2);

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                smp.acquire();
                System.out.println(Colours.ANSI_PURPLE.getValue() + c.getName() + " начал этап: " + description + Colours.ANSI_RESET.getValue());
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Colours.ANSI_PURPLE.getValue() + c.getName() + " закончил этап: " + description + Colours.ANSI_RESET.getValue());
                smp.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
