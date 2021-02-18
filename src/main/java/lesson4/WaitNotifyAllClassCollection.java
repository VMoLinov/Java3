package lesson4;

import java.util.ArrayList;

public class WaitNotifyAllClassCollection {
    private static final ArrayList<String> currentLetter = new ArrayList<>();
    private static int index = 0;

    public static void main(String[] args) {
        currentLetter.add("A");
        currentLetter.add("B");
        currentLetter.add("C");

        WaitNotifyAllClassCollection w = new WaitNotifyAllClassCollection();
        new Thread(() -> w.print(currentLetter.get(currentLetter.indexOf("A")))).start();
        new Thread(() -> w.print(currentLetter.get(currentLetter.indexOf("B")))).start();
        new Thread(() -> w.print(currentLetter.get(currentLetter.indexOf("C")))).start();
    }

    public synchronized void print(String needToPrint) {
        try {
            for (int i = 0; i < 5; i++) {
                while (!needToPrint.equals(currentLetter.get(index))) {
                    wait();
                }
                System.out.print(currentLetter.get(index));
                index = (index == currentLetter.size() - 1) ? 0 : ++index;
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
