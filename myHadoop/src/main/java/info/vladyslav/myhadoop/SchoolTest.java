package info.vladyslav.myhadoop;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

public class SchoolTest {
    @SneakyThrows
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("C:\\Users\\vfrolo\\IdeaProjects\\javaCodeLib\\myHadoop\\students.json");
        Student student = objectMapper.readValue(file, Student.class);

    }
}
