package info.vladyslav.cl.javaBasics.u01core.core_02_strings.str01string;

/**
 * из книги Блинова, пример должен был показать разницу междя мьютебл и иммьютебл классами,
 * но он ничего не показал
 */
public class RefString {
    static String changeStr(String s) {
        s = s.concat(" Certified"); // создается новая строка
        s.concat(" Certified");
        s += " Certified";
        return s;
    }

    static Integer changeInt(Integer i) {
        i = i + 100;
        return i;
    }

    public static void main(String[] args) {
        String str = new String("Java");
        changeStr(str);
        System.out.println(str);

        Integer intt = new Integer(1);
        changeInt(intt);
        System.out.println(intt);
    }
}
