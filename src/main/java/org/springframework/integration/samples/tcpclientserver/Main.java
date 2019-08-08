package org.springframework.integration.samples.tcpclientserver;

import java.util.Scanner;
import org.springframework.context.support.GenericXmlApplicationContext;

public final class Main {

    public static void main(final String... args) {

        final Scanner scanner = new Scanner(System.in);

        System.out.println("\n========================================================="
                + "\n                                                         "
                + "\n          TCP-Client-Server Sample!                      "
                + "\n                                                         "
                + "\n=========================================================");
        final GenericXmlApplicationContext context = Main.setupContext();
        final SimpleGateway gateway = context.getBean(SimpleGateway.class);
        System.out.println("Please enter some text and press <enter>:");

        while (true) {

            final String input = scanner.nextLine();

            if ("q".equalsIgnoreCase(input.trim())) {
                break;
            } else {
                final String result = gateway.send(input);
                System.out.println(result);
            }
        }

        System.out.println("Exiting application...bye.");
        System.exit(0);
    }

    public static GenericXmlApplicationContext setupContext() {

        final GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:META-INF/spring/integration/tcpClientServerDemo-context.xml");
        context.registerShutdownHook();
        context.refresh();

        return context;
    }
}
