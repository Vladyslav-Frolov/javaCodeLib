package info.vladyslav.cl.javaBasics.u01core.core_02_strings.str01string;

public class ConcatenationOperatorPriority {
    public static void main(String[] args) {
        String a = "java " + 2 + 2; // java 22
        String a1 = "java " + 2 + 2.5; // java 22.5
//        String a11 = "java " + 2 - 2.5; // Errors occurred while compiling
        String a111 = "java " + (2 - 2.5); // java -0.5
//        String a12 = "java " + 2 - 2; // Errors occurred while compiling
        String a121 = "java " + (2 - 2); // java 0

        String a2 = "java " + 2 / 2; // java 1
        String a3 = "java " + 2 * 2; // java 4
        String a4 = "java " + 2 % 2; // java 0

        String b = 2 + 2 + " java " + 2 + 2; // 4 java 22
        String c = 2 + 2 + " java " + (2 + 2); // 4 java 4
        String d = (2 + 2) + " java"; // 4 java
//        String e = 2 + 2; // Errors occurred while compiling
        int i = 2;
        String is = "" + i; // 2

        int x = 42;
        double y = 42.25;
        String x1 = "x mod 10: " + x % 10; // x mod 10: 2
        String x2 = "x mod 10: " + x + 10; // x mod 10: 4210
        String y1 = "y mod 10: " + y % 10; // y mod 10: 2.25
        String y2 = "y mod 10: " + y + 10; // y mod 10: 42.2510

        System.out.println(a);
        System.out.println(a1);
        System.out.println(a111);
        System.out.println(a121);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(a4);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

        System.out.println(is);

        System.out.println(x1);
        System.out.println(x2);
        System.out.println(y1);
        System.out.println(y2);
    }

    /**   Приоритет операторов в Java
     высший приоритет
     Постфикс           () [] . (точка) Слева направо
     Унарный            ++ -- ! ~     Справа налево
     Мультипликативный  * / %    Слева направо
     Аддитивный         + -    Слева направо
     Сдвиг              >> >>> <<    Слева направо
     Реляционный        > >= < <=    Слева направо
     Равенство          == !=    Слева направо

     Побитовое «И» («AND»)                  &    Слева направо
     Побитовое исключающее «ИЛИ» («XOR»)    ^    Слева направо
     Побитовое «ИЛИ» («OR»)                 |    Слева направо
     Логическое «И» («AND»)                 &&    Слева направо
     Логическое «ИЛИ» («OR»)                ||    Слева направо

     Условный       ?:    Справа налево
     Присваивание   = += -= *= /= %= >>= <<= &= ^= |=    Справа налево
     Запятая        ,    Слева направо
     низший приоретет
     */
}
