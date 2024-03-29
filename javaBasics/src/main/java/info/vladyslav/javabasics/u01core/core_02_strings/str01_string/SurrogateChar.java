package info.vladyslav.javabasics.u01core.core_02_strings.str01_string;

import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

public class SurrogateChar {
    public static void main(String[] args) {
/*        int[] surrogates = {0xD83D, 0xDC7D};
        String alienEmojiString = new String(surrogates, 0, surrogates.length);
        System.out.println(alienEmojiString);
        System.out.println("\uD83D\uDC7D");   // alternative way
        System.out.println("\uD83D\uDE44");   // alternative way*/

        Character cc = (char) 0x4;
        int i = cc;
        System.out.println(cc + "" + i + " " + 0x1F600);
        System.out.println("-->" + cc + "<--");

        String temp = "megash.cox\u0004aol.com";

        temp = stripInvalidXmlCharacters(temp);

        System.out.println("-->" + temp + "<--");

    }

    // Xml filtering code adapted from:
    // http://stackoverflow.com/a/10894674/3816822
    // for standard XML 1.0 (Fifth Edition) https://www.w3.org/TR/xml/#charsets
    private static String stripInvalidXmlCharacters(String in) {
        char current; // Used to reference the current character.

        if (StringUtils.isEmpty(in)) {
            return ""; // vacancy test.
        }

        for (int i = 0; i < in.length(); i++) {
            current = in.charAt(i);
            // Don't allow the following:
            if ((current <= 0x8) ||
                    ((current >= 0xB) && (current <= 0xC)) ||
                    ((current >= 0xE) && (current <= 0x1F)) ||
                    (current >= 0xfffe)) {
                return deleteInvalidCharForXml(in);
            }
        }
        return in;
    }

    // for standard XML 1.0 (Fifth Edition) https://www.w3.org/TR/xml/#charsets
    private static String deleteInvalidCharForXml(String in) {
        int len = in.length();
        StringBuilder out = new StringBuilder(len); // Used to hold the output.
        char current; // Used to reference the current character.

        for (int i = 0; i < len; i++) {
            current = in.charAt(i);
            // Allow the following:
            if ((current == 0x9) || // Horizontal tab
                    (current == 0xA) || // Newline
                    (current == 0xD) || // Carriage return
                    ((current >= 0x20) && (current <= 0xD7FF)) || // Spaces through the highest admissible meta-character
                    ((current >= 0xE000) && (current <= 0xFFFD)) || // Beginning of valid alphanumeric characters to beginning of a gap in valid xml characters
                    ((current >= 0xD800) && (current <= 0xDFFF))) // End of the gap in valid xml characters to the last alphanumeric character // the range of surrogate pairs is also needed for new types of emojis
                out.append(current);
        }
        return out.toString();
    }

}
