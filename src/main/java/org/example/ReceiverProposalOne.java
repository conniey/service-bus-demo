package org.example;

import com.azure.core.util.IterableStream;
import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusReceivedMessage;
import com.azure.messaging.servicebus.ServiceBusReceiverClient;
import com.azure.messaging.servicebus.ServiceBusSessionReceiverAsyncClient;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class ReceiverProposalOne {
    /**
     * Write code to receive messages from a session with name "my-session". The queue is named "session-queue-0".
     */
    private static void task1() {
        final ServiceBusReceiverClient client = new ServiceBusClientBuilder()
            .connectionString("Endpoint=sb://sb-java-conniey-4.servicebus.windows.net/;SharedAccessKeyName=RootManageSharedAccessKey;SharedAccessKey=foobar")
            .receiver()
            .queueName("session-queue-0")
            .useSessions()
            .buildClient();

        client.acceptSession("my-session");
        final IterableStream<ServiceBusReceivedMessage> message = client.receiveMessages(10);

        final List<ServiceBusReceivedMessage> collect = message.stream().collect(Collectors.toList());
        System.out.println("Found session events: " + collect.size());
    }

    /**
     * Write code to receive messages from the first available session. The queue is named "session-queue-0".
     */
    private static void task2() {
        final ServiceBusReceiverClient client = new ServiceBusClientBuilder()
            .connectionString("Endpoint=sb://sb-java-conniey-4.servicebus.windows.net/;SharedAccessKeyName=RootManageSharedAccessKey;SharedAccessKey=foobar")
            .receiver()
            .queueName("session-queue-0")
            .useSessions()
            .buildClient();

        client.acceptSession();
        final IterableStream<ServiceBusReceivedMessage> message = client.receiveMessages(10);

        final List<ServiceBusReceivedMessage> collect = message.stream().collect(Collectors.toList());
        System.out.println("Found session events: " + collect.size());
    }

    /**
     * Write code to receive and complete messages from all available sessions for 10 seconds.
     * The queue is named "session-queue-0".
     */
    private static void task3() {
        final ServiceBusSessionReceiverAsyncClient sessionReceiver = new ServiceBusClientBuilder()
            .connectionString("Endpoint=sb://sb-java-conniey-4.servicebus.windows.net/;SharedAccessKeyName=RootManageSharedAccessKey;SharedAccessKey=foobar")
            .concurrentSessionReceiver()
            .queueName("session-queue-0")
            .buildAsyncClient();

        sessionReceiver.receiveMessages().take(Duration.ofSeconds(10))
            .flatMap(context -> {
                final ServiceBusReceivedMessage message = context.getMessage();

                System.out.println("Received message: " + message.getMessageId());
                return sessionReceiver.complete(message);
            })
            .blockLast();
    }

    /**
     * What would you expect the behaviour of the following code is?
     */
    private static void task4() {
        final ServiceBusReceiverClient client = new ServiceBusClientBuilder()
            .connectionString("Endpoint=sb://sb-java-conniey-4.servicebus.windows.net/;SharedAccessKeyName=RootManageSharedAccessKey;SharedAccessKey=foobar")
            .receiver()
            .queueName("session-queue-0")
            .useSessions()
            .buildClient();

        // We try accepting the first available session twice.
        client.acceptSession();

        final IterableStream<ServiceBusReceivedMessage> message = client.receiveMessages(10);

        client.acceptSession();

        final List<ServiceBusReceivedMessage> collect = message.stream().collect(Collectors.toList());
        System.out.println("Found session events: " + collect.size());
    }

    public static void main(String[] args) {
        System.out.println("START");
        task1();
        task2();
        task3();
        System.out.println("END");
    }
}
