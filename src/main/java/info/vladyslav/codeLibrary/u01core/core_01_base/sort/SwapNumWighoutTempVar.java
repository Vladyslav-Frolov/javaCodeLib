package info.vladyslav.codeLibrary.u01core.core_01_base.sort;

public class SwapNumWighoutTempVar {
    public static void main(String[] args) {
        // method #1
        int x = 10;
        int y = 5;
        x = x + y;
        y = x - y;
        x = x - y;
        System.out.println("After swap (method #1):"
                + " x = " + x + ", y = " + y);

        int x2 = 18;
        int y2 = 3;

        // method #2
        // Code to swap 'x' and 'y'
        x2 = x2 * y2; // x now becomes 50
        y2 = x2 / y2; // y becomes 10
        x2 = x2 / y2; // x becomes 5

        System.out.println("After swap (method #2):"
                + " x2 = " + x2 + ", y2 = " + y2);

        // Driver code

        int x3 = 10;
        int у3 = 17;
        System.out.println("After swap" + swap(x3, у3));
    }

    static String swap(int x3, int y3) {
        x3 = x3 + y3;
        y3 = x3 - y3;
        x3 = x3 - y3;
        return " (method #3): x3 = " + x3 + ", у3 = " + y3;
    }
}
