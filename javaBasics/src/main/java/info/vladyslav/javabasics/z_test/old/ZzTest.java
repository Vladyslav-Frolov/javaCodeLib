package info.vladyslav.javabasics.z_test.old;

public class ZzTest {
//    public static void main(String[] args) {
///*        int a = 1;
//        System.out.println(a);
//        int a1 = 1;
//        System.out.println(a1);
//        // сначала идёт присвоение а к переменной b, а потом идёт инкремент к а, на b это не влияет
//        int b = a++;
//        System.out.println(b); // 1
//        int b1 = ++a1;
//        System.out.println(b1);
//        // сначала идёт инкремент (прибавление +1) к "а", а потом идёт присоение а к b, b присвоено с увеличением
//        int d = ++a;
//        System.out.println(d);*/
//    }

    public static void main(String[] argv) { // компилируется даже если имя аргумента не "args"
        System.out.println(new Object());
//        System.out.println("test");
//        Scanner scanner = new Scanner(System.in);
//        while(true){
//            System.out.println("ещё кручусь");
//            if(scanner.nextInt() == 0){
//                System.out.println("выхожу, пока \uD83D\uDC4B \uD83D\uDCB5");
//                break;
//            }
//        }

//        String s = "\uD834\uDD1E";
//        System.out.println("𝄞" + "\uD834\uDD1E" + s);
//        System.out.println("🎼");


//        System.out.println("\uD83D\uDE02");
//
//        double d = 0.7;
//        double d2 = 0.2;
//        double d3 = Double.MAX_VALUE;
//
////        System.out.println(d+d2);
//        System.out.println(0 * d3);
//        System.out.println(d3);
//        System.out.println(0.0 / 0); // NaN
//        System.out.println(
//                Integer.toBinaryString(100));

        Integer i1 = 128;
        Integer i2 = 128;

        System.out.println(i1.equals(i2));
        System.out.println(i1 == i2);

//        Object.equals("1", 1);

    }
}
