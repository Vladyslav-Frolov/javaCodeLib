package info.vladyslav.myhadoop;

import lombok.Data;

import java.util.ArrayList;

@Data
public class GroupByMark {
    int mark;
    ArrayList<Student> students = new ArrayList<>();

    public GroupByMark(int mark) {
        this.mark = mark;
    }
}
