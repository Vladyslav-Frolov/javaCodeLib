package info.vladyslav.javabasics.u04patterns.gof_2_structural.str2bridge;

public class BankSystem extends Program {
    public BankSystem(Developer developer) {
        super(developer);
    }

    @Override
    public void developProgram() {
        System.out.println("Bank system development in progress...");
        developer.wrightCode();
    }
}
