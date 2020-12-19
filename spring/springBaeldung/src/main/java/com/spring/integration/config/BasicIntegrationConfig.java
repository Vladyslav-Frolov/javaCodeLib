package com.spring.integration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.BridgeFrom;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.filters.SimplePatternFileListFilter;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

import java.io.File;

// ������ ������ ���� ���� �� ����� test � ������������� � ����� test.1
@Configuration
@EnableIntegration // ��������� ��������, ��� ��� ����� ������������ Spring Integration.
public class BasicIntegrationConfig {
    public String INPUT_DIR = "C:\\Users\\���������\\Desktop\\test";
    public String OUTPUT_DIR = "C:\\Users\\���������\\Desktop\\test\\1";
    public String FILE_PATTERN = "*.docx";

    // ===============================================================
    // ������ ���� ������������ ����������� ����� java --> ��� ����������� ����� � ������ �����
    // ===============================================================

    @Bean // ����� ���������� P-to-P
    public MessageChannel fileChannel() {
        return new DirectChannel();
    }

    @Bean // ������� ��������� ������
    @InboundChannelAdapter(value = "fileChannel", poller = @Poller(fixedDelay = "1000"))
    public MessageSource<File> fileReadingMessageSource() {
        FileReadingMessageSource sourceReader = new FileReadingMessageSource();
        sourceReader.setDirectory(new File(INPUT_DIR));
        sourceReader.setFilter(new SimplePatternFileListFilter(FILE_PATTERN));
        return sourceReader;
    }

    @Bean // ��������� ������ --> �������� ���� �� ������������ �������� ������ � ���������� ��� � ����������� �����
    @ServiceActivator(inputChannel = "fileChannel") // ����� �������� � ��������� �����
    public MessageHandler fileWritingMessageHandler() {
        FileWritingMessageHandler handler = new FileWritingMessageHandler(new File(OUTPUT_DIR));
        handler.setFileExistsMode(FileExistsMode.REPLACE);
        handler.setExpectReply(false);
        return handler;
    }

/*    @Bean // ����� ���������� Pub-Sub
    public MessageChannel pubSubFileChannel() {
        return new PublishSubscribeChannel();
    }*/

    // 3 ����� ��� ����������� �� Pub-Sub � P-to-P (�. �. �� ������ ��� �� ������������)
/*    @Bean
    @BridgeFrom(value = "pubSubFileChannel")
    public MessageChannel fileChannel1() {
        return new DirectChannel();
    }

    @Bean
    @BridgeFrom(value = "pubSubFileChannel")
    public MessageChannel fileChannel2() {
        return new DirectChannel();
    }

    @Bean
    @BridgeFrom(value = "pubSubFileChannel")
    public MessageChannel fileChannel3() {
        return new DirectChannel();
    }*/

/*    @Bean // ������� ��������� ������ ��� P-to-P
    @InboundChannelAdapter(value = "fileChannel", poller = @Poller(fixedDelay = "1000"))
    public MessageSource<File> fileReadingMessageSource() {
        FileReadingMessageSource sourceReader= new FileReadingMessageSource();
        sourceReader.setDirectory(new File(INPUT_DIR));
        sourceReader.setFilter(new SimplePatternFileListFilter(FILE_PATTERN));
        return sourceReader;
    }*/

}