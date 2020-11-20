package com.yet.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class App {
    private Client client;
    private EventLogger eventLogger;
    private Map<EventType,EventLogger> loggers;
    private CacheFileEventLogger defaultLogger;

    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.eventLogger = eventLogger;
        this.loggers = loggers;
    }

    public void setDefaultLogger(CacheFileEventLogger defaultLogger) {
        this.defaultLogger = defaultLogger;
    }

    public App() {
    }

//    public static void main1(String... args) {
//        ApplicationContext parent = new ClassPathXmlApplicationContext("loggers.xml");
//        ApplicationContext child = new ClassPathXmlApplicationContext(new String[]{"others.xml"}, parent);
//
//    }

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring.xml"); // указываем где искать наш xml-файл
        App app = (App) context.getBean("app"); // получаем бин по имени

        app.logEvent(EventType.ERROR,"Some event for user 1", (Event) context.getBean("event"));
        app.logEvent(EventType.INFO,"2222 Some event for user 1", (Event) context.getBean("event"));
        app.logEvent(EventType.INFO,"3333 Some event for user 1", (Event) context.getBean("event"));
        app.logEvent(EventType.TEST,"3333 Some event for user 1", (Event) context.getBean("event"));

        Client cl = (Client) context.getBean("client");
        System.out.println(cl.getGreeting());

//        App app = new App();
//        app.client = new Client("1", "John Smith");
//        app.eventLogger = new ConsoleEventLogger();
//        app.logEvent("Some event for user 1");
        ConfigurableApplicationContext appContext = (ConfigurableApplicationContext) context;
        appContext.close();
    }

    private void logEvent(EventType type, String msg, Event event) {
        EventLogger logger = loggers.get(type);

        if(logger == null){
            logger = defaultLogger;
        }

        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);
        logger.logEvent(event);
    }
}
