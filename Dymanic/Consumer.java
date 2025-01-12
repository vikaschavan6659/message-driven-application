package Dymanic;
import java.util.Random;

public class Consumer implements Runnable {
    private final MessageQueue queue;
    private final int errorProbability;
    private static int successCount = 0;
    private static int errorCount = 0;

    public Consumer(MessageQueue queue, int errorProbability) {
        this.queue = queue;
        this.errorProbability = errorProbability;
    }

    @Override
    public void run() {
        Random random = new Random();

        while (true) {
            try {
                String message = queue.dequeue();
                System.out.println(Thread.currentThread().getName() + " Consumed: " + message);

                // Simulate processing with error probability
                if (random.nextInt(100) < errorProbability) {
                    throw new RuntimeException("Error processing: " + message);
                }

                synchronized (Consumer.class) {
                    successCount++;
                }
                System.out.println("Successfully processed: " + message);
            } catch (RuntimeException e) {
                synchronized (Consumer.class) {
                    errorCount++;
                }
                System.err.println(e.getMessage());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}