package com.spring.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component("itemProcessor")
public class SingeritemProcessor implements ItemProcessor<Singer, Singer> {
    private static Logger logger =
            LoggerFactory.getLogger(SingeritemProcessor.class);

    @Override
    public Singer process(Singer singer) throws Exception {
        Integer id = singer.getId();
        String firstName = singer.getFirstName().toUpperCase();
        String lastName = singer.getLastName().toUpperCase();
        String song = singer.getSong().toUpperCase();
        Singer transformedSinger = new Singer();
        transformedSinger.setId(id);
        transformedSinger.setFirstName(firstName);
        transformedSinger.setLastName(lastName);
        transformedSinger.setSong(song);
        logger.info("Transformed singer: " + singer + " Into: "
                + transformedSinger);
        return transformedSinger;
    }
}
