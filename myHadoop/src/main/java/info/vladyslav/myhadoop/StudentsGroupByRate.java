package info.vladyslav.myhadoop;

import lombok.Data;

import java.util.ArrayList;

@Data
public class StudentsGroupByRate {
    ArrayList<StudentWithSchool> bestStudents;
    ArrayList<StudentWithSchool> middleStudents;
    ArrayList<StudentWithSchool> worstStudents;
}
