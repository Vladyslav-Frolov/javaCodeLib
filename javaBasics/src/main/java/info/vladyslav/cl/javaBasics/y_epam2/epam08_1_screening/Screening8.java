package info.vladyslav.cl.javaBasics.y_epam2.epam08_1_screening;

public class Screening8 {
}
class A extends Object{//line a
    int i =3;
}

class B extends A {
    int i = 4;
}

class Main{
    public static void main(String[] args) {
        Object a = new B();//line b
//        System.out.println(a.i); //line c
    }
}

/**What will be the result of the following code?
 * Compile error on line a
 * 3
 * 4
 * Compile error on line b
 * Compile error on line c <-- correct
 * */