package info.vladyslav.jackson;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import info.vladyslav.jackson.pojo.Car;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class RawValue {
//    @JsonRawValue
    private static String carJson;
    public long personId = 0;

    @JsonRawValue
    public Object address;

    static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        RawValue rawValue = new RawValue();
        Car car = new Car();

        carJson = "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";

        car = objectMapper.readValue(carJson, Car.class);

        System.out.println(car);
        System.out.println("car brand = " + car.getBrand());
        System.out.println("car doors = " + car.getDoors());

        Reader reader = new StringReader(carJson);
    }

}
