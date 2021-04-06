package info.vladyslav.javabasics.z_test;

public class Z_10 {
    Integer zip = 1000000000;


    public static void main(String[] args) {
        Z_10 z = new Z_10();
        Z_9 z9 = new Z_9();

        int i1 = 1000000000;
        Integer i2 = 1000000000;
        int i3 = 10;
        String s;


        System.out.println(i1==i2);
        System.out.println(i3==z9.i);
        System.out.println(i1==z9.ii);
        System.out.println(i2==z9.ii);
        System.out.println(i2.equals(z9.ii));
        System.out.println(i2 == z.zip);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
