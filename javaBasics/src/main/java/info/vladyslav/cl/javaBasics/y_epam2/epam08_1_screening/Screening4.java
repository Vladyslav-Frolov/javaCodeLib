package info.vladyslav.cl.javaBasics.y_epam2.epam08_1_screening;

public class Screening4 implements Books{

    @Override
    public String getType() {
        return null;
    }

    public static void main(String[] args) {
        Screening4 scr = new Screening4();
        System.out.println(scr.getType());
    }
}
//--------------------------------------------------------
interface Books {
    //insert code here
public String type = "Fiction";
public abstract String getType();
}
/*
 * A.
 * public abstract String type;
 * public abstract String getType();
 * B.
 * public static String type;
 * public abstract String getType();
 * C.
 * public static String type = "Fiction";
 * public static String getType();
 * D. <-- correct
 * public String type = "Fiction";
 * public abstract String getType();
 * */