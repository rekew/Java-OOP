import java.util.concurrent.RecursiveTask;

public class FindMaxTask extends RecursiveTask<Integer> {
    private final int threshold;
    private final int[] myArray;
    private final int start;
    private final int end;

    public FindMaxTask(int[] myArray, int start, int end, int threshold) {
        this.myArray = myArray;
        this.start = start;
        this.end = end;
        this.threshold = threshold;
    }

    @Override
    protected Integer compute() {
        if ((end - start) < threshold) {
            int max = myArray[start];
            for (int i = start + 1; i <= end; i++) {
                if (myArray[i] > max) {
                    max = myArray[i];
                }
            }
            return max;
        } else {
            int midway = (start + end) / 2;
            FindMaxTask task1 = new FindMaxTask(myArray, start, midway, threshold);
            FindMaxTask task2 = new FindMaxTask(myArray, midway + 1, end, threshold);

            invokeAll(task1, task2);

            return Math.max(task1.join(), task2.join());
        }
    }
}
