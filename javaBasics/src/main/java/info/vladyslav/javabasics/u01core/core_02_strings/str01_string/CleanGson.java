package info.vladyslav.javabasics.u01core.core_02_strings.str01_string;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.google.gson.Gson;

public class CleanGson {
    @JsonRawValue
    static String str;


    public static void main(String[] args) {
        str = "Hello \"World\"";
        String payload = new Gson().toJson(new Payload("Hello \"World\""));

        System.out.println(new Gson().toJson(new Payload(str)));

        System.out.println(payload);
        System.out.println("Hello \"World\"");
    }

    static class Payload {
        @JsonRawValue
        String message;

        Payload(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}