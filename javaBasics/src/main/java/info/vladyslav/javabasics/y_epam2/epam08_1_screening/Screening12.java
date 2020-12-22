package info.vladyslav.javabasics.y_epam2.epam08_1_screening;

public class Screening12 {
}
class AA{
    void doit(){
        System.out.println("A");
    }
}
class BB extends AA{
    void doit(){
        System.out.println("B");
    }

    public static void main(String[] args) {
        BB bb = new BB();
        bb.go();
    }
    void go(){
        super.doit();
    }
}
/**What will be the result of the following code?
 * Compilation error
 * A <-- correct
 * nothing will be printed
 * B
 * */