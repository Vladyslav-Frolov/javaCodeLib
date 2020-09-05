package info.vladyslav.codeLibrary.u04patterns.gof_2_structural.str2bridge;

public class StockExchange extends Program {
    public StockExchange(Developer developer) {
        super(developer);
    }

    @Override
    public void developProgram() {
        System.out.println("Stock exchange development in progress...");
        developer.wrightCode();
    }
}
