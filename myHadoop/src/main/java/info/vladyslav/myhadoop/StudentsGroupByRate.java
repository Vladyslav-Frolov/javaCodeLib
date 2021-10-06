package info.vladyslav.myhadoop;

import lombok.Data;

import java.util.ArrayList;

@Data
public class StudentsGroupByRate {
    String performance;
    ArrayList<StudentWithSchool> students;
}
