package Dymanic;
import java.util.Random;

public class Producer implements Runnable {
    private final MessageQueue queue;
    private final int messageCount;

    public Producer(MessageQueue queue, int messageCount) {
        this.queue = queue;
        this.messageCount = messageCount;
    }

    @Override
    public void run() {
        for (int i = 1; i <= messageCount; i++) {
            try {
                String message = "Message-" + i;
                queue.enqueue(message);
                System.out.println(Thread.currentThread().getName() + " Produced: " + message);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}