public class MessageQueueApp {
    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue(5);

        Producer producer = new Producer(messageQueue);
        Consumer consumer = new Consumer(messageQueue);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join(1000); // Stop consumer after some time
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Total Success Count: " + Consumer.getSuccessCount());
        System.out.println("Total Error Count: " + Consumer.getErrorCount());
    }
}