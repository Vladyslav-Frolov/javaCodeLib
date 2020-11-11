package info.vladyslav.codelibrary.u04patterns.gof_3_behavioral.beh09strategy;

public class Developer {
    private Activity activity;

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void executeActivity(){
        activity.justDoIt();
    }
}
