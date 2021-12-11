package info.vladyslav.javabasics.u01core.core_02_strings.str01_string;

public class SurrogateChar {
    public static void main(String[] args) {
/*        int[] surrogates = {0xD83D, 0xDC7D};
        String alienEmojiString = new String(surrogates, 0, surrogates.length);
        System.out.println(alienEmojiString);
        System.out.println("\uD83D\uDC7D");   // alternative way
        System.out.println("\uD83D\uDE44");   // alternative way*/

        char cc = (char) 0x2639;
        int i = cc;
        System.out.println(cc + " " + i + " " + 0x1F600);
    }


}
