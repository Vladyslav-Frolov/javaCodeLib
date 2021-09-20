package info.vladyslav.mytests;

import com.fasterxml.jackson.databind.ObjectMapper;
import info.vladyslav.mytests.Vehicle;
import lombok.SneakyThrows;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class OutputJson {


    @SneakyThrows
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        Vehicle vehicle = new Vehicle();
        vehicle.setBrand("Mersedes");
        vehicle.setYear(2020);

        Vehicle.Wheel wheel1 = new Vehicle().new Wheel();
        wheel1.setDiameter(10.);
        wheel1.setMark("GoodYear1");

        Vehicle.Wheel wheel2 = new Vehicle().new Wheel();
        wheel2.setDiameter(10.);
        wheel2.setMark("GoodYear2");

        Vehicle.Wheel wheel3 = new Vehicle().new Wheel();
        wheel3.setDiameter(10.);
        wheel3.setMark("GoodYear3");

        Vehicle.Wheel wheel4 = new Vehicle().new Wheel();
        wheel4.setDiameter(10.);
        wheel4.setMark("GoodYear4");

        vehicle.setWheels(new ArrayList<>(Arrays.asList(wheel1, wheel2, wheel3, wheel4)));

        objectMapper.writeValue(
                new FileOutputStream("myHadoop/output-2.json"), vehicle);
    }

}
