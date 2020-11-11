package info.vladyslav.codelibrary.y_epam2.epam16_1_screening;

import java.io.*;

public class MyQuaere3 {
    BufferedWriter bw;
//    BufferedWriter b1 = new BufferedWriter(new File("f")); // Line1
    BufferedWriter b2 = new BufferedWriter(new FileWriter("f1")); // Line2
    BufferedWriter b3 = new BufferedWriter(new PrintWriter("f2")); // Line3
    BufferedWriter b4 = new BufferedWriter(new BufferedWriter(bw)); // Line3

    public MyQuaere3() throws IOException {
    }
}
/**
 * What will be the result of the following code fragment,
 * given that bw is a valid reference to a BufferedWriter?
 *
 * Compilation succeeds
 * Compilation error on multiple lines
 * Compilation error only at the //Line2 (I)
 * Compilation error only at the //Line3
 * Compilation error only at the //Line4
 * Compilation error only at the //Line1 <-- correct
 */