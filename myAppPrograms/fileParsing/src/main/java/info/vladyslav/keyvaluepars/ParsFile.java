package info.vladyslav.keyvaluepars;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import static info.vladyslav.util.GetScannerFromFile.getScannerFromFile;

public class ParsFile {
    public static final String FILE_NAME_FOR_READ = "C:/Users/¬ладислав/Desktop/english.txt";
    public static final String FILE_NAME_FOR_WRITE_1 = "C:/Users/¬ладислав/Desktop/english_key.txt";
    public static final String FILE_NAME_FOR_WRITE_2 = "C:/Users/¬ладислав/Desktop/english_values.txt";

    static LinkedHashMap<String, String> mapForSave = new LinkedHashMap<>();


    public static void main(String[] args) {
        getInput(FILE_NAME_FOR_READ);
        writeFileKey(mapForSave);
        writeFileValue(mapForSave);
    }

    public static void writeFileValue(Map<String, String> mapForSave) {

        try (PrintWriter writer = new PrintWriter(FILE_NAME_FOR_WRITE_2)) {
            for (String s : mapForSave.values()) {
                writer.println(s);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void writeFileKey(Map<String, String> mapForSave) {

        try (PrintWriter writer = new PrintWriter(FILE_NAME_FOR_WRITE_1)) {
            for (String s : mapForSave.keySet()) {
                writer.println(s);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, String> getInput(String fileName) {
        String lineForParse;
        String[] tokens;

        try {
            Scanner scanner = getScannerFromFile(fileName);
            while (scanner.hasNextLine()) {
                lineForParse = scanner.nextLine();

                if (lineForParse.contains(" Ч ")) {
                    tokens = lineForParse.split(" \\u2014 "); // " Ч "
                } else if (lineForParse.contains(" - ")) {
                    tokens = lineForParse.split(" - "); // " - "
                } else if (lineForParse.contains("Ч ")) {
                    tokens = lineForParse.split("\\u2002\\u2014 "); // " Ч "
                } else if (lineForParse.contains(" Ч")) {
                    tokens = lineForParse.split(" \\u2014\\u2002"); // " Ч "
                } else if (lineForParse.contains("Ч")) {
                    tokens = lineForParse.split("\\u2002\\u2014\\u2002"); // " Ч "
                } else {
                    tokens = lineForParse.split(" \\u2192 "); // " right arrow "
                }
                mapForSave.put(tokens[0].toLowerCase(), tokens[1].toLowerCase());
            }
            scanner.close();
            return mapForSave;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
