package info.vladyslav.codeLibrary.patterns.behavioral.interpreter;

public class InterpreterRunner {
    public static void main(String[] args) {
        Expression isJava = getJavaExperession();
        Expression isJavaEEDeveloper = getJavaEEExperession();

        System.out.println("Does developer knows Java Core: " + isJava.interpret("Java Core"));
        System.out.println("Does developer knows Java EE: " + isJavaEEDeveloper.interpret("Java Spring"));
    }

    public static Expression getJavaExperession() {
        Expression java = new TerminalExpression("Java");
        Expression javaCor = new TerminalExpression("Java Core");

        return new OrExpression(java, javaCor);
    }

    public static Expression getJavaEEExperession() {
        Expression java = new TerminalExpression("Java");
        Expression spring = new TerminalExpression("Spring");
        return new AndExpression(java, spring);
    }

}
