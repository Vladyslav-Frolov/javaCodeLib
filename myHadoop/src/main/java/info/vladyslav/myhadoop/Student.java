package info.vladyslav.myhadoop;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {
    String name;
    int cLass;
    int mark;
}
