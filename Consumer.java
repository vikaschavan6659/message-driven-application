public class Consumer implements Runnable {
    private final MessageQueue messageQueue;
    private static int successCount = 0;
    private static int errorCount = 0;

    public Consumer(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String message = messageQueue.consume();
                processMessage(message);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void processMessage(String message) {
        try {
            System.out.println("Processing: " + message);
            successCount++;
        } catch (Exception e) {
            System.err.println("Error processing: " + message);
            errorCount++;
        }
    }

    public static int getSuccessCount() {
        return successCount;
    }

    public static int getErrorCount() {
        return errorCount;
    }
}