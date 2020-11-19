package info.vladyslav.springcore;

import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {

    private int cacheSize;
    private List<Event> cache;

    public CacheFileEventLogger(int cacheSize, String fileName) {
        super(fileName);
        this.cacheSize = cacheSize;
        cache = new ArrayList<>();
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);

        if (cache.size() == cacheSize) {
            wrightEvensFromCache();
            cache.clear();
        }
    }

    private void wrightEvensFromCache() {
        for (Event event : cache) {
            setOutput(event);
        }
    }

    public void destroy() {
        if (!cache.isEmpty())
            wrightEvensFromCache();
    }
}
