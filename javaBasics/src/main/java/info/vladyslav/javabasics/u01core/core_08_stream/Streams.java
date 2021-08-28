package info.vladyslav.javabasics.u01core.core_08_stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;


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



    private class Department{
        Integer id;
        Integer parent;
        String name;

        public Department(Integer id, Integer parent, String name) {
            this.id = id;
            this.parent = parent;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public Integer getParent() {
            return parent;
        }

        public String getName() {
            return name;
        }
    }

    private class Employee {
        String firstName;
        String lastName;
        Integer id;
        Integer age;
        Position position;

        public Employee(String firstName, String lastName, Integer id, Integer age, Position position) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.id = id;
            this.age = age;
            this.position = position;
        }
    }

    enum Position {
        CHEF, MANAGER, WORKER
    }
}
