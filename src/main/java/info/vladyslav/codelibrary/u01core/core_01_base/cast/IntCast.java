package info.vladyslav.codelibrary.u01core.core_01_base.cast;

public class IntCast {
    public static void main(String[] args) {
        long xx = 10;
        int i = (int) (2 * xx);
        i = (2 * (int) xx);

        byte a = 40, b = 50;
        byte sum = (byte) (a + b); // правильный вариант
//        byte sum2 = (byte) a + b; // ошибка, т. е. <b> приводится к int, а <a> к byte
        System.out.println(sum);

        // перенести в папку XOR (побитовое сравенние), только пара true/false → даёт true, остальные → false
        boolean x = true;
        boolean z = true;
        int y = 20;
        x = y != 10 ^ (z = false);
        System.out.println(x);

        int x1 = 10;
        System.out.println(x1 > 2 ? x1 < 4 ? 10 : 8 : 7);

        String [] ssss = {"1", "2"};
//        String s2 = new String(ssss); // ошибка
    }

}
