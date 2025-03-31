package lab8.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreadInterruptedMain {
    public static void main(String[] args) {
        // Создаём объект Counter и поток
        Runnable r = new Counter();
        Thread t = new Thread(r);
        t.start();

        // Ждём нажатия Enter
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            br.readLine(); // Ждёт ввода
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Проверка активности потока
        System.out.println("Thread is alive: " + t.isAlive());

        // Прерывание потока
        t.interrupt();

        // Даём потоку время завершиться
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Повторная проверка активности потока
        System.out.println("Thread is alive: " + t.isAlive());
    }
}
