package com.spring.integration.epam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.dsl.Pollers;

import java.util.concurrent.atomic.AtomicInteger;

@Configuration
@ComponentScan("com.spring.integration.epam")
@EnableIntegration
public class MyConfiguration {

/*    @Bean
    public AtomicInteger integerSource() {
        return new AtomicInteger();
    }

    @Bean
    public IntegrationFlow myFlow() {
        return IntegrationFlows.from(integerSource().getAndIncrement(), c -> c.poller(Pollers.fixedRate(10)))
                .channel("inputChannel")
                .filter((Integer p) -> p > 1) // фильтруем больше одного
                .transform(Object::toString) // переводим в стринги
                .channel(MessageChannels.queue())
                .get(); // аналог билдера, вместо метода build()
    }*/

}
