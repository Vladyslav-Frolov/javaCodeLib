package info.vladyslav.myhadoop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class SchoolTest4Line {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true);

        ArrayList<Student> students = new ArrayList<>();
        InvalidRecords invalidRecords = new InvalidRecords();
        ArrayList<String> forInvalids = new ArrayList<>();
        ArrayList<StudentsGroupByMark> studentsGroupByMarks = new ArrayList<>();

        File file = new File("myHadoop/students.json");

        FileReader fr;
        BufferedReader reader = null;
        String line = null;
        try {
            //создаем объект FileReader для объекта File
            fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            reader = new BufferedReader(Objects.requireNonNull(fr));
            // считаем сначала первую строку
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (line != null) {
            // заменяем нераспасиваемые кавычки на обычные
            String newLine = line.replaceAll("[“”]", "\"");

            try {
                // проверяем на наличие правильно заполненных полей
                Student student = objectMapper.readValue(newLine, Student.class);
                if (student.getCLass() < 1 || student.getCLass() > 12 ||
                        student.getMark() < 0 || student.getMark() > 5 ||
                        student.getName().equals("")) {
                    forInvalids.add(newLine);
                } else {
                    // если всё правильно --> наполняем коллекцию студентов
                    students.add(student);
                }
            } catch (IOException e) {
                //  дополняем колекцию невалидных строк при выбрасывании ошибки
                forInvalids.add(newLine);
            }
            try {
                // считываем остальные строки в цикле
                line = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        students.forEach(System.out::println);

        // фильтруем студентов собирая 5-й и выше классы
        students = students.stream().filter(f -> f.getCLass() >= 5).collect(Collectors.toCollection(ArrayList::new));


        // собираем студентов по оценкам // (!) код не эффективен, есть возможность улучить
        for (int i = 1; i <= 5; i++) {
            StudentsGroupByMark studentsGroupByMark = new StudentsGroupByMark(i);

            for (Student student : students) {
                if(student.getMark() == i){
                    studentsGroupByMark.getStudents().add(student);
                }
            }
            studentsGroupByMarks.add(studentsGroupByMark);
        }


        System.out.println(students);
        System.out.println(forInvalids);

//        System.out.println(groupByMarks);

        invalidRecords.setInvalid_records(forInvalids);

        String json = objectMapper.writeValueAsString(studentsGroupByMarks);
        System.out.println(json);
        try {
//            objectMapper.writeValue(
//                    new FileOutputStream("myHadoop/output-2.json"), invalidRecords);
            objectMapper.writeValue(
                    new FileOutputStream("myHadoop/output-1.json"), studentsGroupByMarks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
