package info.vladyslav.springcore;

import java.util.Collection;

public class CombinedEventLogger implements EventLogger{
    private Collection<EventLogger> loggers;
    @Override
    public void logEvent(Event event) {
        for (EventLogger logger : loggers) {
            logger.logEvent(event);
        }
    }

    public CombinedEventLogger(Collection<EventLogger> loggers) {
        this.loggers = loggers;
    }
}
