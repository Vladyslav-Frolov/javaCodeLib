package info.vladyslav.javabasics.u01core.core_08_stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Streams {
/*    private List<Employee> emps = List.of(
            new Employee("Michael", "Smith", 243, 43, Position.CHEF),
            new Employee("Jane", "Smith", 244, 33, Position.MANAGER),
            new Employee("Jury", "Gagarin", 984, 55, Position.WORKER),
            new Employee("Jack", "London", 158, 18, Position.WORKER)
    );*/

/*    private List<Department> departments = List.of(
            new Department(1, 0, "Head"),
            new Department(2, 1, "West"),
            new Department(3, 2, "East"),
            new Department(4, 3, "Germany")
    );*/

    public static void main(String[] args) throws IOException {
//        Stream<String> lines = Files.lines(Paths.get("some.txt"));

/*        Streams streams = new Streams();
        List<String> collect = streams.departments
                .stream()
                .map(Department::getName)
                .collect(Collectors.toList());
        System.out.println(collect); // [Head, West, East, Germany]

        // fill random int
        ArrayList<Integer> inst = Stream
                .iterate(new SecureRandom().nextInt(100), (x) -> new SecureRandom().nextInt(100))
                .limit(5)
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println(inst); // random --> [86, 46, 1, 98, 77]*/

        // fill random string
/*        ArrayList<String> strings = Stream
                .iterate("init", (x) -> new SecureRandom().nextString(100))
                .limit(5)
                .collect(Collectors.toCollection(ArrayList::new));*/

//        System.out.println(strings); // random -->

    }


    @AllArgsConstructor
    @Data
    private class Department {
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
