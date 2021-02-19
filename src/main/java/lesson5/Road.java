package lesson5;

public class Road extends Stage {
    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            System.out.println(Colours.ANSI_CYAN.getValue() + c.getName() + " начал этап: " + description + Colours.ANSI_RESET.getValue());
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(Colours.ANSI_CYAN.getValue() + c.getName() + " закончил этап: " + description + Colours.ANSI_RESET.getValue());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
