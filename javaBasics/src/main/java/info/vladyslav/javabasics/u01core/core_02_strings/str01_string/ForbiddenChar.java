package info.vladyslav.javabasics.u01core.core_02_strings.str01_string;

import org.apache.commons.lang3.StringUtils;

public class ForbiddenChar {


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

        System.out.println("=====================");
        String temp = "{\"userEmailAddress\":\"meg\\u0009ash.cox\\u0004aol.com\\udsfa\"}";
//        String temp = "1";
        String temp2 = "don't allow chars --> \u0000, \uFFFE, \uFFFF";


        System.out.println(temp);
        temp = stripInvalidXmlCharacters(temp);
        System.out.println("-->" + temp + "<--");

        System.out.println();
        System.out.println(temp2);
        temp2 = stripInvalidXmlCharacters(temp2);
        System.out.println("-->" + temp2 + "<--");

    }

    // Xml filtering code adapted from:
    // http://stackoverflow.com/a/10894674/3816822
    // for standard XML 1.0 (Fifth Edition) https://www.w3.org/TR/xml/#charsets
    private static String stripInvalidXmlCharacters(String in) {
        char current; // Used to reference the current character.
        StringBuilder out = new StringBuilder();

        if (StringUtils.isEmpty(in)) {
            return ""; // vacancy test.
        }

        char fetchedChar = 0;
        StringBuilder chaar = new StringBuilder();

        for (int i = 0; i < in.length(); i++) {
            current = in.charAt(i);

            // test for escape sequence
            if (current == '\\' && in.charAt(i + 1) == 'u') {
                chaar.append(in.charAt(i + 2));
                chaar.append(in.charAt(i + 3));
                chaar.append(in.charAt(i + 4));
                chaar.append(in.charAt(i + 5));
                try {
                    fetchedChar = (char) Integer.parseInt(String.valueOf(chaar), 16);
                } catch (NumberFormatException ignored) {
                    out.append(current);
                }

                if (!isAllowedChars(fetchedChar)) {
                    i += 5;
                    continue;
                }
            }
            if (!isAllowedChars(current)) {
                continue;
            }
            out.append(current);
        }
        return out.toString();
    }

    private static boolean isAllowedChars(char current) {
        // Don't allow the following:
        return (current > 0x0008) &&
                ((current < 0x000B) || (current > 0x000C)) &&
                ((current < 0x000E) || (current > 0x001F)) &&
                (current < 0xfffe);
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
