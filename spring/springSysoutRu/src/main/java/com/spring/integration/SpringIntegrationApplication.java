package com.spring.integration;

import com.spring.integration.model.Animal;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

@Configuration
@ComponentScan("com.spring.integration")
@EnableIntegration
public class SpringIntegrationApplication {
    @Bean
    DirectChannel outputChannel() {
        return new DirectChannel();
    }

    @MessagingGateway
    public interface I {

        @Gateway(requestChannel = "animalFlow.input")
        void process(Animal animal);
    }

    // канал DirectChannel с именем animalFlow.input создается автоматически
    @Bean
    public IntegrationFlow animalFlow() {
        return flow -> flow
                .handle("aService", "process")
                .handle("bService", "process")
                .handle("cService", "process")
                .channel("outputChannel");
    }

    public static void main(String[] args) {
        final AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(SpringIntegrationApplication.class);
        ctx.registerShutdownHook();

        DirectChannel outputChannel = ctx.getBean("outputChannel", DirectChannel.class);
        // обработчик внутри subscribe выполнится как только закончится выполнение flow
        outputChannel.subscribe(System.out::println);
        // запускаем выполнение flow
//        ctx.getBean(I.class).process(new Animal("cat"));

        // можно было запустить flow отправкой сообщения во входной канал input:
         MessageChannel inputChannel = ctx.getBean("animalFlow.input", MessageChannel.class);
         inputChannel.send(MessageBuilder.withPayload(new Animal("cat")).build());
        ctx.close();
    }
}
