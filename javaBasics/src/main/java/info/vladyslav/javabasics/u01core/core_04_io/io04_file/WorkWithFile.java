package info.vladyslav.javabasics.u01core.core_04_io.io04_file;

import java.io.File;

public class WorkWithFile {
    public static void main(String[] args) {
        File file = new File("/Users/vfrolo/test.sh");
        System.out.println(file.getName());
        System.out.println(file.exists());
        System.out.println(file.length());
    }
}
