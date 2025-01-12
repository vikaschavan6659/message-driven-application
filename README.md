# Message-Driven Producer-Consumer Application
 
This is a simple Java application that simulates a Producer-Consumer scenario using a message queue. The application tracks and logs the total number of messages processed successfully and the number of errors encountered.
 
 
---
 
Features
 
Producer-Consumer Simulation: Uses multiple threads to simulate the producer-consumer problem with a shared message queue.
 
Message Tracking: Tracks successfully processed messages and errors encountered.
 
Logging: Logs each produced and consumed message along with the result (success/error).
 
Unit Testing: Includes JUnit test cases to test both successful and failure scenarios.
 
 
 
---
 
Requirements
 
Java: JDK 8 or later
 
JUnit: JUnit 4.13 or later for testing
 
 
 
---
 
Getting Started
 
1. Clone the Repository
 
git clone 'https://github.com/vikaschavan6659/message-driven-application.git/
cd producer-consumer-app
 
 
---
 
2. Compile the Application
 
You need to compile the Java files before running the application.
 
1. Navigate to the src directory where your Java files are located.
 
 
2. Compile all the Java files:
 
javac -d bin src/*.java
 
This will compile the Java files and output the .class files into the bin directory.
 
 
 
 
---
 
3. Run the Application
 
Once the application is compiled, run the main application with the following command:
 
java -cp bin MainApplication
 
This will start the producer and consumer threads, and you will see logs showing the message production, consumption, and the success/error counts.
 
 
---
 
4. Unit Tests
 
Unit tests are written using JUnit to verify both successful message processing and error handling.
 
Steps to Run the Unit Tests:
 
1. Compile the Test Files:
 
Download and include junit-4.13.2.jar and hamcrest-core-1.3.jar in the classpath.
 
Compile the test files along with JUnit:
 
javac -d bin -cp junit-4.13.2.jar:hamcrest-core-1.3.jar src/test/*.java
 
 
 
2. Run the Unit Tests:
 
java -cp bin:junit-4.13.2.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore MessageQueueTest
 
The test results will be shown in the terminal, and they will indicate if the tests for successful and failure scenarios pass or fail.
