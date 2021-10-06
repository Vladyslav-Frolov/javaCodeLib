package info.vladyslav.myhadoop;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentsGroupByMark {
    private int mark;
    private ArrayList<Student> students = new ArrayList<>();

    public StudentsGroupByMark(int mark, List<Student> students) {
        this.mark = mark;
        this.students = (ArrayList<Student>) students;
    }

    public StudentsGroupByMark(int mark) {
        this.mark = mark;
    }

    public StudentsGroupByMark() {
    }
}
