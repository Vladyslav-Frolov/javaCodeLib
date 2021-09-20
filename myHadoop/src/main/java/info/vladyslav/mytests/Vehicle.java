package info.vladyslav.mytests;

import lombok.Data;

import java.util.List;

@Data
public class Vehicle {
    String brand;
    int year;
    List<Wheel> wheels;

    @Data
    public class Wheel {
        double diameter;
        String mark;
    }
}
