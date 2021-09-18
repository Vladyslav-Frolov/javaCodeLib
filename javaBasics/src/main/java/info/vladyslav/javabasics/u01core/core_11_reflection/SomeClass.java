package info.vladyslav.javabasics.u01core.core_11_reflection;


public class SomeClass {
    String s = "text";
    int i = 123;
    String setString;

    public SomeClass() {
    }

    public SomeClass(String setString) {
        this.setString = setString;
    }

    public void someMethod() {
        System.out.println("I am here");
    }

    public void someMethodSecond(String s) {
        System.out.println("I am here second");
    }

    public void someMethodThird(String s, int i, boolean b) {
        System.out.println("I am here third" + s);
    }

    public void printSetString() {
        System.out.println(this.setString);
    }

    public void printStringAndSetString(String argString) {
        System.out.println(this.setString + argString);
    }

}
