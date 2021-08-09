package info.vladyslav.javabasics.u01core.core_01_base.bs20_interface;

@FunctionalInterface
public interface Main {
    int INTEGER = 10;
    Double DOUBLE = 10.;

    double divide(double T, double E);

    static double multiply(double T, double E) {
        return T * E;
    }

    default double multiply2(double T, double E) {
        return (T * E) * 2;
    }

    private double multiply3(double T, double E) {
        return (T * E) * 2;
    }

    class TestPrivateInterfaceClass {
        public static void main(String[] args) {
            System.out.println(multiply(30., 2.));
            Main main = new Main(

            ) {
                @Override
                public double divide(double T, double E) {
                    return 0;
                }
            };
            System.out.println(main.multiply3(3., 2.));
        }
    }
}
