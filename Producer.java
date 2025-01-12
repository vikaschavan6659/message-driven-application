public class Producer implements Runnable {
    private final MessageQueue messageQueue;

    public Producer(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                messageQueue.produce("Message-" + i);
                Thread.sleep(500); // Simulate production delay
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}