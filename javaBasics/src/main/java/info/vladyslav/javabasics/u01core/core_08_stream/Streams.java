package info.vladyslav.javabasics.u01core.core_08_stream;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;


public class Streams {
    private List<Employee> emps = List.of(
            new Employee("Michael", "Smith", 243, 43, Position.CHEF),
            new Employee("Jane", "Smith", 244, 33, Position.MANAGER),
            new Employee("Jury", "Gagarin", 984, 55, Position.WORKER),
            new Employee("Jack", "London", 158, 18, Position.WORKER)
    );

    private List<Department> departments = List.of(
            new Department(1,0,"Head"),
            new Department(2,1,"West"),
            new Department(3,2,"East"),
            new Department(4,3,"Germany")
    );

    public static void main(String[] args) throws IOException {
//        Stream<String> lines = Files.lines(Paths.get("some.txt"));

Streams streams = new Streams();
        List<String> collect = streams.departments
                .stream()
                .map(department -> department.getName())
                .collect(Collectors.toList());
        System.out.println(collect);


    }


    @AllArgsConstructor
    @Data
    private class Department{
        Integer id;
        Integer parent;
        String name;

    }
    @AllArgsConstructor
    @Data
    private class Employee {
        String firstName;
        String lastName;
        Integer id;
        Integer age;
        Position position;

    }

    enum Position {
        CHEF, MANAGER, WORKER
    }
}
