package info.vladyslav.mytests;

import java.io.File;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import info.vladyslav.myhadoop.Student;
import lombok.SneakyThrows;

public class SchoolTest {
    @SneakyThrows
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("myHadoop/student.json");
        Student student = objectMapper.readValue(file, Student.class);

        System.out.println(student);
    }
}
