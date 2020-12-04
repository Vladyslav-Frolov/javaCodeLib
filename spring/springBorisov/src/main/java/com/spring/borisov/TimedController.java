package com.spring.borisov;

// for jvisualvm.exe
public class TimedController implements TimedControllerMBean {
    private boolean enabled = true;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
