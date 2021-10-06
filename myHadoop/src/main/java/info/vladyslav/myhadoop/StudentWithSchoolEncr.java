package info.vladyslav.myhadoop;

import lombok.Data;

@Data
public class StudentWithSchoolEncr {
    private byte[] name;
    private  int cLass;
    private  int mark;
    private   String schoolName;
    private   String schoolAddress;
}
