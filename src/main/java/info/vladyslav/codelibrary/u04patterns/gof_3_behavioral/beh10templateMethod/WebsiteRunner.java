package info.vladyslav.codelibrary.u04patterns.gof_3_behavioral.beh10templateMethod;

public class WebsiteRunner {
    public static void main(String[] args) {
        WebsiteTemplate welComePage = new WelComePage();
        WebsiteTemplate newsPage = new NewsPage();


        welComePage.showPage();

        System.out.println("\n===================================\n");

        newsPage.showPage();
    }
}
