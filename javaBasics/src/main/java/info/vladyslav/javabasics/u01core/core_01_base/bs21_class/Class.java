package info.vladyslav.javabasics.u01core.core_01_base.bs21_class;

class Class {

    public static void main(String[] args) {
        Private aPrivate = new Class().new Private();
        System.out.println(aPrivate.i); // 10

        // in method class
        class InnerMethodClass{
            private int test = 1000;
        }

        InnerMethodClass inClass = new InnerMethodClass();
        System.out.println(inClass.test); // 1000

        System.out.println(Private2.i); // 20

        Private2 private2 = new Private2();
        System.out.println(private2.i2); // 30

    }

    private class Private{
        private int i = 10;
    }

    private static class Private2{
        private static int i = 20;

        private int i2 = 30;
    }
}
