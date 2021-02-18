package lesson4;

public class WaitNotifyAllClass {
    private char currentLetter = 'A';

    public static void main(String[] args) {
        WaitNotifyAllClass w = new WaitNotifyAllClass();
        new Thread(() -> w.print('A', 'B')).start();
        new Thread(() -> w.print('B', 'C')).start();
        new Thread(() -> w.print('C', 'A')).start();
    }

    public synchronized void print(char needToPrint, char nextToPrint) {
        try {
            for (int i = 0; i < 5; i++) {
                while (needToPrint != currentLetter) {
                    wait();
                }
                System.out.print(currentLetter);
                currentLetter = nextToPrint;
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
