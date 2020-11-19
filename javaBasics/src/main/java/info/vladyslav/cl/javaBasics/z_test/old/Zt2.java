package info.vladyslav.cl.javaBasics.z_test.old;

public abstract class Zt2 {
    void test(int i){
        System.out.println("test1");
    }

    void test(String s){
        System.out.println("test2");
    }

    abstract void test(char a);
}

interface Zt3{}
interface Zt4{}

abstract class InharitageZt2 extends Zt2 implements Zt3, Zt4{
    @Override
    void test(String s){
        System.out.println("test3");
    }

    public static void main(String[] args) {
        Zt2 zt2 = new InharitageZt2() {
            @Override
            void test(char a) {

            }
        };
        zt2.test("test");
    }
}