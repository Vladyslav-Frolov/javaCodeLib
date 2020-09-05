package info.vladyslav.codeLibrary.u01core.core_04_io.io01io;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {

    public static void main(String args[]) {

        writeToRandomAccessFile("sample.txt", 0, "2222222222\n");
        writeToRandomAccessFile("sample.txt", 10, "2222222222\n");

        String fromFile = readFromRandomAccessFile("sample.txt", 0);
        System.out.println(fromFile);

    }

    /*
     * Utility method to read from RandomAccessFile in Java
     */
    public static String readFromRandomAccessFile(String file, int position) {
        String record = null;
        try {
            RandomAccessFile fileStore = new RandomAccessFile(file, "rw");

            // moves file pointer to position specified
            fileStore.seek(position);

            // reading String from RandomAccessFile
            record = fileStore.readLine();

            fileStore.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return record;
    }

    /*
     * Utility method for writing into RandomAccessFile in Java
     */
    public static void writeToRandomAccessFile(String file, int position, String record) {
        try {
            RandomAccessFile fileStore = new RandomAccessFile(file, "rw");

            // moves file pointer to position specified
            fileStore.seek(position);

            // writing String to RandomAccessFile
            fileStore.writeUTF(record);

            fileStore.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}