package info.vladyslav.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GetScannerFromFile {
    private GetScannerFromFile() {
    }

    public static Scanner getScannerFromFile(String fileName) throws FileNotFoundException {
        return new Scanner(new File(fileName), "UTF-8"); // cp1251, UTF-8
    }
}
