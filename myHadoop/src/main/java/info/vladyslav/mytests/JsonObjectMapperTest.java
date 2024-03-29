package info.vladyslav.mytests;


import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import info.vladyslav.mytests.Car;

public class JsonObjectMapperTest {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        String carJson =
                "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";

        try {
            Car car = objectMapper.readValue(carJson, Car.class);

            System.out.println("car brand = " + car.getBrand());
            System.out.println("car doors = " + car.getDoors());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
