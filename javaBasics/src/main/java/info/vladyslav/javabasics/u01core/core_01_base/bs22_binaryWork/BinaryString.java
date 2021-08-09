package info.vladyslav.javabasics.u01core.core_01_base.bs22_binaryWork;

public class BinaryString {
    public static void main(String[] args) {
        System.out.println(Integer.bitCount(20));
        int i = (16 - 1) & 2306996;
        System.out.println(i);
        System.out.println("-------------");
        System.out.println(Integer.toBinaryString(16));
        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(15));
        System.out.println(Integer.toBinaryString(2306996));
        System.out.println(Integer.toBinaryString(i));
        System.out.println("-------------");

        System.out.println(Integer.bitCount(i));
        System.out.println(i);
    }
}
