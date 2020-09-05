package info.vladyslav.codeLibrary.u04patterns.gof_3_behavioral.beh06memento;

import java.util.Date;

public class Save {
    private final String version;
    private final Date date;

    public Save(String version) {
        this.version = version;
        this.date = new Date();
    }

    public String getVersion() {
        return version;
    }

    public Date getDate() {
        return date;
    }
}
