package lab8.second;

public class Counter implements Runnable {
    @Override
    public void run() {
        int x = 0;
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("The current value of x is: " + x++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Выходим из цикла, если поток был прерван во время сна
                return;
            }
        }
    }
}
