package info.vladyslav.javabasics.z_test.old;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

import static com.sun.xml.internal.messaging.saaj.packaging.mime.util.ASCIIUtility.getBytes;

public class Z_2_Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Locale locale = Locale.getDefault();
        System.out.println(locale.getDisplayName()); // English (United States)
        System.out.println(locale.getDefault()); // en_US

        Locale loc = new Locale ("de", "CH");
        System.out.println (loc.getDisplayName (Locale.GERMAN)); // Deutsch (Schweiz)

        Locale loc2 = new Locale ("ru", "UA");
        System.out.println (loc2.getDisplayName (Locale.US)); // Russian (Ukraine)

        ResourceBundle bundle;
//        bundle = ResourceBundle.getBundle("ProgramResources",
//                loc);

//        System.out.println(bundle); // MissingResourceException: Can't find bundle for base name ProgramResources, locale de_CH

        System.out.println("☺".length());

        byte[] uni = getBytes("стол");
        System.out.println(Arrays.toString(uni));

        String str1 = "\u0000";
        String str2 = "\uFFFF";
        byte[] arr = str1.getBytes("UTF-8");
        byte[] brr = str2.getBytes("UTF-8");
        System.out.println("UTF-8 for \\u0000");
        for(byte a: arr) {
            System.out.print(a);
        }
        System.out.println("\nUTF-8 for \\uffff" );
        for(byte b: brr) {
            System.out.print(b);
        }
    }
}