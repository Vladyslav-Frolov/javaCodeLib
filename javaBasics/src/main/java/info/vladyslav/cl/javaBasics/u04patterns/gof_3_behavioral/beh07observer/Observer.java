package info.vladyslav.cl.javaBasics.u04patterns.gof_3_behavioral.beh07observer;

import java.util.List;

public interface Observer {
    public void handleIvent(List<String> vacancies);
}