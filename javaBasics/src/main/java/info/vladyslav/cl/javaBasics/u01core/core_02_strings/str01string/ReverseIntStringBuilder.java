package info.vladyslav.cl.javaBasics.u01core.core_02_strings.str01string;

public class ReverseIntStringBuilder {
    public static void main(String[] args) {
        ReverseIntStringBuilder reverse = new ReverseIntStringBuilder();
        System.out.println(reverse.reverse(452487945));
    }

    int reverse(int i) {
        StringBuilder reverse = new StringBuilder();
        reverse = reverse.append(i).reverse();
        String string = String.valueOf(reverse);
        System.out.println(i);
        return Integer.valueOf(string);
    }
}
