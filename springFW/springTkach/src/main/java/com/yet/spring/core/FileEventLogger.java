package com.yet.spring.core;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileEventLogger implements EventLogger {
    private static final Logger LOGGER = Logger.getLogger(FileEventLogger.class.getName());

    private String fileName;
    private File file;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public FileEventLogger() {
    }

    @Override
    public void logEvent(Event event) {
        setOutput(event);
    }

    void setOutput(Object objects) {
        StringBuilder logFile = readFromFile(fileName);
        logFile.append(objects);
        try (PrintWriter writer = new PrintWriter(fileName)) {
            writer.print(logFile);
        } catch (IOException e) {
            LOGGER.log(Level.INFO, String.format("%s can`t write file %s", e, fileName));
        }
    }

    public void init() throws IOException {
//        try (PrintWriter writer = new PrintWriter(fileName)) {
//            writer.print("");
//        } catch (IOException e) {
//            LOGGER.log(Level.INFO, String.format("%s can`t write file %s", e, fileName));
//        }
        this.file = new File(fileName);
        if (!file.canWrite())
            throw new IOException();
    }

    public StringBuilder readFromFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(fileName), "cp1251");
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }
            scanner.close();
            return sb;
        } catch (IOException ex) {
            LOGGER.log(Level.INFO, ex.toString());
        }
        return sb;
    }
}
