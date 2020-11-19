package info.vladyslav.cl.javaBasics.u01core.core_01_base.bs03BinaryOperators;

import java.util.Arrays;

public class BinaryRightShiftOperator {
    private static final Object[] EMPTY_ELEMENTDATA = {};
    int oldCapacity = 1004874;

    int newCapacity = oldCapacity >> 3; // число равно степени числа 2 в делителе
    // Т. е. ">>1" = "/(2^1)"[2] // ">>2" = "/(2^2)"[4] // ">>3" = "/(2^3)"[8].

    public static void main(String[] args) {
        BinaryRightShiftOperator binaryRightShiftOperator = new BinaryRightShiftOperator();
        System.out.println(Arrays.toString(binaryRightShiftOperator.EMPTY_ELEMENTDATA));
        System.out.println(Integer.toBinaryString(binaryRightShiftOperator.oldCapacity));
        System.out.println(Integer.toBinaryString(binaryRightShiftOperator.newCapacity));

        System.out.println(binaryRightShiftOperator.newCapacity);
        System.out.println(binaryRightShiftOperator.oldCapacity/8);
    }
}
