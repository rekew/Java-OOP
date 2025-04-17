import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        int arraySize = 1_000_000;
        int threshold = 10_000;

        int[] data = new int[arraySize];

        ForkJoinPool fjPool = new ForkJoinPool();

        // Commented out the original single-threaded array initialization
        // for (int i = 0; i < data.length; i++) {
        //     data[i] = (int) (Math.random() * 100000);
        // }

        // Используем RandomArrayAction для инициализации массива
        RandomArrayAction action = new RandomArrayAction(data, 0, data.length - 1, threshold);
        fjPool.invoke(action);

        // После инициализации, ищем максимальное значение
        FindMaxTask findMaxTask = new FindMaxTask(data, 0, data.length - 1, threshold);
        int max = fjPool.invoke(findMaxTask);

        System.out.println("Максимальное значение: " + max);
    }
}
