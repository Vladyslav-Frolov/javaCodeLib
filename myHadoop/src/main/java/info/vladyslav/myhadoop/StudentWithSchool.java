package info.vladyslav.myhadoop;

import lombok.Data;

@Data
public class StudentWithSchool {
    private String name;
    private  int cLass;
    private  int mark;
    private   String schoolName;
    private   String schoolAddress;

    public StudentWithSchool() {
    }

    public StudentWithSchool(String name, int cLass, int mark, String schoolName, String schoolAddress) {
        this.name = name;
        this.cLass = cLass;
        this.mark = mark;
        this.schoolName = schoolName;
        this.schoolAddress = schoolAddress;
    }
}
