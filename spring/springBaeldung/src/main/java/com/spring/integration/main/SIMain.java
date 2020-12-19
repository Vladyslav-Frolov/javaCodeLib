package com.spring.integration.main;

import com.spring.integration.config.SeparateFlowsExample;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.Scanner;

public class SIMain {
    public static void main(final String... args) {
        final AbstractApplicationContext context = new AnnotationConfigApplicationContext(SeparateFlowsExample.class);
        context.registerShutdownHook();
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a string and press <enter>: ");
        while (true) {
            final String input = scanner.nextLine();
            if ("q".equals(input.trim())) {
                context.close();
                scanner.close();
                break;
            }
        }
        System.exit(0);
    }
}
