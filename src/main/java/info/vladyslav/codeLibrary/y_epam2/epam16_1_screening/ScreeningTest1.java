package info.vladyslav.codeLibrary.y_epam2.epam16_1_screening;

public class ScreeningTest1 {
    public static void main(String[] args) {
        System.out.println(nextInt()); // 20
    }

    static int nextInt() {
        try {
            String[] arr = {"text1", "text2"};
            System.out.println(arr[5]);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return 10;
        } finally {
            return 20;
        }
    }
}
/**
 * 20
 */