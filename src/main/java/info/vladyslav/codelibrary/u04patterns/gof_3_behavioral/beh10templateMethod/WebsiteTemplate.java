package info.vladyslav.codelibrary.u04patterns.gof_3_behavioral.beh10templateMethod;

public abstract class WebsiteTemplate {
    public void showPage() {
        System.out.println("Header");
        showPageContent();
        System.out.println("Footer");
    }

    public abstract void showPageContent();
}
