package info.vladyslav.counting;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Scanner;

import static info.vladyslav.util.GetScannerFromFile.getScannerFromFile;

public class CountingMatches {
    public static final String FILE_NAME_FOR_READ = "C:/Users/Владислав/Desktop/count.txt";
    public static final String SEARCH_FOR = "[";

    static LinkedHashMap<String, String> mapForSave = new LinkedHashMap<>();


    public static void main(String[] args) {
        System.out.println(getCountMatches(FILE_NAME_FOR_READ));

    }

    public static int getCountMatches(String fileName) {
        int counter = 0;

        try {
            Scanner scanner = getScannerFromFile(fileName);
            while (scanner.hasNextLine()) {

                if (scanner.nextLine().contains(SEARCH_FOR))
                    counter +=1;
            }
            scanner.close();
            return counter;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
}
