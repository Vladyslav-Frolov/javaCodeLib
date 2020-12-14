package com.spring.integration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.PriorityChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.core.GenericSelector;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.messaging.MessageHandler;

import java.io.File;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;


// ������ ������ ���� ���� �� ����� test � ������������� � ����� test.1
@Configuration
@EnableIntegration // ��������� ��������, ��� ��� ����� ������������ Spring Integration.
public class IntegrationConfigDsl {
    public String INPUT_DIR = "C:\\Users\\���������\\Desktop\\test";
    public String OUTPUT_DIR = "C:\\Users\\���������\\Desktop\\test\\1";
    public String FILE_PATTERN = "*.docx";


    // ===============================================================
    // ������ ���� �� ���� �����, �� ����� Java DSL
    // ===============================================================

    @Bean
    public IntegrationFlow fileMover() {
        return IntegrationFlows.from(sourceDirectory() // ������ �������� ��������� ������
                , configurer -> configurer.poller( // ���������� ������������ � ���������
                        Pollers.fixedDelay(1_000)) // 1 ���.
        )
                .filter((File source) -> source.getName().startsWith("tes"))
//                .channel("alphabetically") // ----- ������� ������ (�� �������� ������ No poller has been defined for endpoint)
                .handle(targetDirectory()) // �������� ������� ���������� ������ @ServiceActivator
                // add more components
                .get();
    }


    @Bean // ������ �������� ��������� ������ @InboundChannelAdapter
    public MessageSource<File> sourceDirectory() {
        FileReadingMessageSource messageSource = new FileReadingMessageSource();
        messageSource.setDirectory(new File(INPUT_DIR));
        return messageSource;
    }

    @Bean // �������� ������� ���������� ������ @ServiceActivator
    public MessageHandler targetDirectory() {
        FileWritingMessageHandler handler = new FileWritingMessageHandler(new File(OUTPUT_DIR));
        handler.setFileExistsMode(FileExistsMode.REPLACE);
        handler.setExpectReply(false); // ������ ����� ����������������
        return handler;
    }


/*    @Bean // ������, ������ ��� �� ������ ������ � ���������� ����, �. �. �� �������
    public GenericSelector<File> onlyJpgs() {
        return source -> source.getName().startsWith("tes");
    }*/

    /*    @Bean // ----- �� ���������
    public PriorityChannel alphabetically() {
        return new PriorityChannel(1000, (left, right) ->
                ((File) left.getPayload()).getName().compareTo(
                        ((File) right.getPayload()).getName()));
    }*/

    // ��������������� ������ IntegrationFlow
/*    @Bean
    public IntegrationFlow myFlow() {
        return IntegrationFlows.from(fileReadingMessageSource(), c -> c.poller(Pollers.fixedRate(10)))
                .channel("fileChannel")
                .filter((Integer p) -> p > 1) // ��������� ������ ������
                .transform(Object::toString) // ��������� � �������
                .channel(MessageChannels.queue())
                .get(); // ������ �������, ������ ������ build()
    }*/


    // ===============================================================
    // ������ ���� --> ����
    // ===============================================================

/*    @Bean // ������ ���� � ���������� � ����� "holdingTank"
    public IntegrationFlow fileReader() {
        return IntegrationFlows.from(sourceDirectory())
                .filter(onlyJpgs())
                .channel("holdingTank")
                .get();
    }

    @Bean // ���������� ����� "holdingTank" � ���������� � ����
    public IntegrationFlow fileWriter() {
        return IntegrationFlows.from("holdingTank")
                .bridge(e -> e.poller(Pollers.fixedRate(1, TimeUnit.SECONDS, 20)))
                .handle(targetDirectory())
                .get();
    }*/

/*    @Bean // ���� ��������� ��� ���� �����, ������� ����� �� �� ����� �� ������ "holdingTank" � ���������� �� � ������ ���������
    public IntegrationFlow anotherFileWriter() {
        return IntegrationFlows.from("holdingTank")
                .bridge(e -> e.poller(Pollers.fixedRate(2, TimeUnit.SECONDS, 10)))
                .handle(anotherTargetDirectory())
                .get();
    }*/
}
