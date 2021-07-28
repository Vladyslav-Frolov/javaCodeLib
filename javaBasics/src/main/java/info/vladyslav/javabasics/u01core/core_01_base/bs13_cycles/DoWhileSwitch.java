package info.vladyslav.javabasics.u01core.core_01_base.bs13_cycles;

import java.util.Scanner;

public class DoWhileSwitch {
    public static void main(String[] args) {
        byte n;
        String shape = null;

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1) Введите блок\n" +
                    "2) Введите сферу\n" +
                    "3) Введите пирамиду\n" +
                    "4) Показать выбор\n");
            n = sc.nextByte();
            switch (n) {
                case 1:
                    shape = "блок";
                    break;
                case 2:
                    shape = "сфера";
                    break;
                case 3:
                    shape = "пирамида";
                    break;

                // дефолт лучше не использовать в сочитании ду-вайл, дефолт идеален в просто вайл
//                default:
//                    System.out.println("вы ошиблись");
//                    break;
            }
        }
        while (n != 4);
        System.out.println("Показ данных:");
        System.out.println(shape);
    }
}
