package info.vladyslav.codelibrary.u04patterns.gof_2_structural.str2bridge;

public abstract class Program {
    protected Developer developer;

    protected Program(Developer developer){
        this.developer = developer;
    }
public abstract void developProgram();
}
