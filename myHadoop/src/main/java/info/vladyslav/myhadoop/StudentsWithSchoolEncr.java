package info.vladyslav.myhadoop;

import lombok.Data;

import java.util.ArrayList;

@Data
public class StudentsWithSchoolEncr {
    String performance;
    ArrayList<StudentWithSchoolEncr> studentsWithSchoolEncr;
}
