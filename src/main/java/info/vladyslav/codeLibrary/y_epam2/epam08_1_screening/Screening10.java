package info.vladyslav.codeLibrary.y_epam2.epam08_1_screening;

public class Screening10 {
}

class Employee2 {
    Employee2(byte i) {
        System.out.println("Good day employee!");
    }

    Employee2(short in) {
        System.out.println("Good night employee!");
    }

    Employee2(long i) {
        System.out.println("Good morning employee!");
    }
}

class Main3 {
    public static void main(String[] args) {
        Employee2 e = new Employee2(6);
    }
}
/**
 * What will be the result of the following code?
 * Compilation error
 * Good day employee!
 * Good night employee!
 * Good morning employee! <-- correct
 */