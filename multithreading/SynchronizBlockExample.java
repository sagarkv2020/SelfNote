package acn.multithreading;

class Printer {
    void printNumbers(int n) {
        synchronized (this) {
            for (int i = 1; i <= n; i++) {
                System.out.println(Thread.currentThread().getName() + " prints: " + i);
                try {
                    Thread.sleep(100); // Simulate delay
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class MyThread extends Thread {
    Printer printer;

    MyThread(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        printer.printNumbers(5);
    }
}

public class SynchronizBlockExample {
    public static void main(String[] args) {
        Printer sharedPrinter = new Printer();

        Thread t1 = new MyThread(sharedPrinter);
        Thread t2 = new MyThread(sharedPrinter);

        t1.setName("Thread-1");
        t2.setName("Thread-2");

        t1.start();
        t2.start();
    }
}