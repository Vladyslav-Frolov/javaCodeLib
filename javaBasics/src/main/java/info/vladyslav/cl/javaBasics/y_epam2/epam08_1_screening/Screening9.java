package info.vladyslav.cl.javaBasics.y_epam2.epam08_1_screening;

public class Screening9 {
}
class Employee{
    Employee(){
        System.out.println("Constructor");
    }
}

class Main2 {
    public static void main(String[] args) {
        Employee e = new Employee();
//        e.Employee();
    }
}

/**What will be the result of the following code?
 * null Constructor
 * Compilation error <-- correct
 * Constructor null
 * Constructor Constructor
 * */