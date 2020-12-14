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


// данный пример берёт файл из папки test и перекладывает в папку test.1
@Configuration
@EnableIntegration // аннотация означает, что это класс конфигурации Spring Integration.
public class IntegrationConfigDsl {
    public String INPUT_DIR = "C:\\Users\\Владислав\\Desktop\\test";
    public String OUTPUT_DIR = "C:\\Users\\Владислав\\Desktop\\test\\1";
    public String FILE_PATTERN = "*.docx";


    // ===============================================================
    // второй урок всё тоже самое, но через Java DSL
    // ===============================================================

    @Bean
    public IntegrationFlow fileMover() {
        return IntegrationFlows.from(sourceDirectory() // замена адаптера входящего канала
                , configurer -> configurer.poller( // добавление опрашивателя с задержкой
                        Pollers.fixedDelay(1_000)) // 1 сек.
        )
                .filter((File source) -> source.getName().startsWith("tes"))
//                .channel("alphabetically") // ----- вставка канала (не работает ошибка No poller has been defined for endpoint)
                .handle(targetDirectory()) // является заменой активатора службы @ServiceActivator
                // add more components
                .get();
    }


    @Bean // замена адаптера входящего канала @InboundChannelAdapter
    public MessageSource<File> sourceDirectory() {
        FileReadingMessageSource messageSource = new FileReadingMessageSource();
        messageSource.setDirectory(new File(INPUT_DIR));
        return messageSource;
    }

    @Bean // является заменой активатора службы @ServiceActivator
    public MessageHandler targetDirectory() {
        FileWritingMessageHandler handler = new FileWritingMessageHandler(new File(OUTPUT_DIR));
        handler.setFileExistsMode(FileExistsMode.REPLACE);
        handler.setExpectReply(false); // делает поток однонаправленным
        return handler;
    }


/*    @Bean // фильтр, данный бин на прямую вписан в интегрейшн флоу, т. к. он простой
    public GenericSelector<File> onlyJpgs() {
        return source -> source.getName().startsWith("tes");
    }*/

    /*    @Bean // ----- не заработал
    public PriorityChannel alphabetically() {
        return new PriorityChannel(1000, (left, right) ->
                ((File) left.getPayload()).getName().compareTo(
                        ((File) right.getPayload()).getName()));
    }*/

    // альттернативный пример IntegrationFlow
/*    @Bean
    public IntegrationFlow myFlow() {
        return IntegrationFlows.from(fileReadingMessageSource(), c -> c.poller(Pollers.fixedRate(10)))
                .channel("fileChannel")
                .filter((Integer p) -> p > 1) // фильтруем больше одного
                .transform(Object::toString) // переводим в стринги
                .channel(MessageChannels.queue())
                .get(); // аналог билдера, вместо метода build()
    }*/


    // ===============================================================
    // второй урок --> мост
    // ===============================================================

/*    @Bean // читает файл и записывает в поток "holdingTank"
    public IntegrationFlow fileReader() {
        return IntegrationFlows.from(sourceDirectory())
                .filter(onlyJpgs())
                .channel("holdingTank")
                .get();
    }

    @Bean // опрашивает поток "holdingTank" и записывает в файл
    public IntegrationFlow fileWriter() {
        return IntegrationFlows.from("holdingTank")
                .bridge(e -> e.poller(Pollers.fixedRate(1, TimeUnit.SECONDS, 20)))
                .handle(targetDirectory())
                .get();
    }*/

/*    @Bean // мост добавляем еще один поток, который берет те же файлы из канала "holdingTank" и записывает их с другой скоростью
    public IntegrationFlow anotherFileWriter() {
        return IntegrationFlows.from("holdingTank")
                .bridge(e -> e.poller(Pollers.fixedRate(2, TimeUnit.SECONDS, 10)))
                .handle(anotherTargetDirectory())
                .get();
    }*/
}
