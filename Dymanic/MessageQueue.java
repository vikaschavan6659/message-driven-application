package Dymanic;
import java.util.LinkedList;
import java.util.Queue;

public class MessageQueue {
    private final Queue<String> queue;
    private final int capacity;

    public MessageQueue(int capacity) {
        this.queue = new LinkedList<>();
        this.capacity = capacity;
    }

    public synchronized void enqueue(String message) throws InterruptedException {
        while (queue.size() == capacity) {
            wait();
        }
        queue.add(message);
        notifyAll();
    }

    public synchronized String dequeue() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        String message = queue.poll();
        notifyAll();
        return message;
    }
}