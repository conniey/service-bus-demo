package org.example;

import com.azure.core.util.IterableStream;
import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusReceivedMessage;
import com.azure.messaging.servicebus.ServiceBusReceiverClient;
import com.azure.messaging.servicebus.ServiceBusSessionProcessorClient;
import com.azure.messaging.servicebus.ServiceBusSessionProcessorClientBuilder;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class ReceiverProposalTwo {
    /**
     * Write code to receive a message from session with name "my-session".
     */
    private static void task1() {
        // final ServiceBusReceiverClient client = new ServiceBusClientBuilder()
        //     .connectionString("Endpoint=sb://sb-java-conniey-4.servicebus.windows.net/;SharedAccessKeyName=RootManageSharedAccessKey;SharedAccessKey=foobar")
        //     .receiver()
        //     .queueName("session-queue-0")
        //     .useSessions("my-session")
        //     .buildClient();
        //
        // client.acceptSession();
        // final IterableStream<ServiceBusReceivedMessage> message = client.receiveMessages(10);
        //
        // final List<ServiceBusReceivedMessage> collect = message.stream().collect(Collectors.toList());
        // System.out.println("Found session events: " + collect.size());
    }

    /**
     * Write code to receive a message from the first available session.
     */
    private static void task2() {
        // final ServiceBusReceiverClient client = new ServiceBusClientBuilder()
        //     .connectionString("Endpoint=sb://sb-java-conniey-4.servicebus.windows.net/;SharedAccessKeyName=RootManageSharedAccessKey;SharedAccessKey=foobar")
        //     .receiver()
        //     .queueName("session-queue-0")
        //     .useSessions()
        //     .buildClient();
        //
        // client.acceptSession();
        // final IterableStream<ServiceBusReceivedMessage> message = client.receiveMessages(10);
        //
        // final List<ServiceBusReceivedMessage> collect = message.stream().collect(Collectors.toList());
        // System.out.println("Found session events: " + collect.size());
    }

    /**
     * Write code to receive and complete messages from all available sessions for 10 seconds.
     */
    private static void task3() {
        // final ServiceBusSessionProcessorClient sessionReceiver = new ServiceBusSessionProcessorClientBuilder()
        //     .connectionString("Endpoint=sb://sb-java-conniey-4.servicebus.windows.net/;SharedAccessKeyName=RootManageSharedAccessKey;SharedAccessKey=foobar")
        //     .queueName("session-queue-0")
        //     .buildSessionProcessorClient();
        //
        // sessionReceiver.receiveMessages().take(Duration.ofSeconds(10))
        //     .flatMap(context -> {
        //         final ServiceBusReceivedMessage message = context.getMessage();
        //
        //         System.out.println("Received message: " + message.getMessageId());
        //         return sessionReceiver.complete(message);
        //     })
        //     .blockLast();
    }

    public static void main(String[] args) {
        System.out.println("START");
        task1();
        task2();
        task3();
        System.out.println("END");
    }
}
