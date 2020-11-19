package info.vladyslav.cl.javaBasics.u04patterns.gof_3_behavioral.beh03interpreter;

public class TerminalExpression implements Expression {
    String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        if (context.contains(data)){
            return true;
        }
        return false;
    }
}
