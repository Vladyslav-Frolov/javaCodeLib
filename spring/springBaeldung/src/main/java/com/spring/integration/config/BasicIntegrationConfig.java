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

// данный пример берёт файл из папки test и перекладывает в папку test.1
@Configuration
@EnableIntegration // аннотация означает, что это класс конфигурации Spring Integration.
public class BasicIntegrationConfig {
    public String INPUT_DIR = "C:\\Users\\Владислав\\Desktop\\test";
    public String OUTPUT_DIR = "C:\\Users\\Владислав\\Desktop\\test\\1";
    public String FILE_PATTERN = "*.docx";

    // ===============================================================
    // превый урок конфигурация интегрейшин через java --> для копирование файла в другую папку
    // ===============================================================

    @Bean // канал интеграции P-to-P
    public MessageChannel fileChannel() {
        return new DirectChannel();
    }

    @Bean // адаптер входящего канала
    @InboundChannelAdapter(value = "fileChannel", poller = @Poller(fixedDelay = "1000"))
    public MessageSource<File> fileReadingMessageSource() {
        FileReadingMessageSource sourceReader = new FileReadingMessageSource();
        sourceReader.setDirectory(new File(INPUT_DIR));
        sourceReader.setFilter(new SimplePatternFileListFilter(FILE_PATTERN));
        return sourceReader;
    }

    @Bean // активатор службы --> получает файл из настроенного входного канала и записывает его в настроенную папку
    @ServiceActivator(inputChannel = "fileChannel") // можно добавить и исходящий канал
    public MessageHandler fileWritingMessageHandler() {
        FileWritingMessageHandler handler = new FileWritingMessageHandler(new File(OUTPUT_DIR));
        handler.setFileExistsMode(FileExistsMode.REPLACE);
        handler.setExpectReply(false);
        return handler;
    }

/*    @Bean // канал интеграции Pub-Sub
    public MessageChannel pubSubFileChannel() {
        return new PublishSubscribeChannel();
    }*/

    // 3 моста для подключения от Pub-Sub к P-to-P (т. к. на прямую они не подключаются)
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

/*    @Bean // адаптер входящего канала для P-to-P
    @InboundChannelAdapter(value = "fileChannel", poller = @Poller(fixedDelay = "1000"))
    public MessageSource<File> fileReadingMessageSource() {
        FileReadingMessageSource sourceReader= new FileReadingMessageSource();
        sourceReader.setDirectory(new File(INPUT_DIR));
        sourceReader.setFilter(new SimplePatternFileListFilter(FILE_PATTERN));
        return sourceReader;
    }*/

}