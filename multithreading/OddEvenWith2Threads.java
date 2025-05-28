package acn.multithreading;


class AlternatePrinter {

    private int number = 1;
    private final int MAX = 10;

    public void printOdd() {
        synchronized (this) {
            while (number <= MAX) {
                if (number % 2 == 0) {
                    try {
                        wait();
                        notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Odd Thread: " + number);
                    number++;
                    notify();
                }
            }
        }
    }

    public void printEven() {
        synchronized (this) {
            while (number <= MAX) {
                if (number % 2 == 0) {
                    System.out.println("Even Thread: " + number);
                    number++;
                    notify();

                } else {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}


public class OddEvenWith2Threads {
    public static void main(String[] args) {
        AlternatePrinter printer = new AlternatePrinter();

        Thread t1 = new Thread(() -> printer.printOdd());
        Thread t2 = new Thread(() -> printer.printEven());

        t1.start();
        t2.start();

    }
}
