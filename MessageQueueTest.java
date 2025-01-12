import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MessageQueueTest {
    @Test
    public void testSuccessfulMessageProcessing() throws InterruptedException {
        MessageQueue queue = new MessageQueue(5);
        Consumer consumer = new Consumer(queue);
        Producer producer = new Producer(queue);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join(1000);

        Assertions.assertEquals(10, Consumer.getSuccessCount());
        Assertions.assertEquals(0, Consumer.getErrorCount());
    }

    @Test
    public void testErrorScenario() throws InterruptedException {
        MessageQueue queue = new MessageQueue(5);
        Consumer consumer = new Consumer(queue);

        Thread consumerThread = new Thread(() -> {
            try {
                consumer.processMessage(null); // Force an error
            } catch (Exception e) {
                Assertions.assertNotNull(e);
            }
        });

        consumerThread.start();
        consumerThread.join();

        Assertions.assertEquals(1, Consumer.getErrorCount());
    }
}