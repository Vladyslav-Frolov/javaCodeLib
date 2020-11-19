package info.vladyslav.cl.javaBasics.z_test.old;


public class Z_4_Test {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_MAGENTA = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        System.out.println(ANSI_RED + "This text is Red" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "This text is Green" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "This text is Yellow" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "This text is Blue" + ANSI_RESET);
        System.out.println(ANSI_MAGENTA + "This text is Magenta" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "This text is Cyan" + ANSI_RESET);
        System.out.println(ANSI_WHITE + "This text is White" + ANSI_RESET);
    }



}
