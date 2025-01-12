package Dymanic;
import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Dynamic Configuration
        System.out.println("Enter number of Producers:");
        int numProducers = scanner.nextInt();

        System.out.println("Enter number of Consumers:");
        int numConsumers = scanner.nextInt();

        System.out.println("Enter Queue Size:");
        int queueSize = scanner.nextInt();

        System.out.println("Enter number of messages to produce:");
        int messageCount = scanner.nextInt();

        System.out.println("Enter error probability (0-100):");
        int errorProbability = scanner.nextInt();

        // Initialize the queue
        MessageQueue queue = new MessageQueue(queueSize);

        // Start Producers
        for (int i = 0; i < numProducers; i++) {
            new Thread(new Producer(queue, messageCount)).start();
        }

        // Start Consumers
        for (int i = 0; i < numConsumers; i++) {
            new Thread(new Consumer(queue, errorProbability)).start();
        }
    }
}