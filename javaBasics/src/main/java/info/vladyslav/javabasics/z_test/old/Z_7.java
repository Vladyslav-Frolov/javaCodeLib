package info.vladyslav.javabasics.z_test.old;

import java.util.ArrayList;
import java.util.List;

public class Z_7 {
    private static List<String> authorizedCommands = new ArrayList<>();

    static {
        // authorized commands
        authorizedCommands.add("signIn");
        authorizedCommands.add("ownCabinet");
        authorizedCommands.add("toBook");

    }

    // test commands for existence
    public static boolean isAuthorized(String commandName) {
        return authorizedCommands.contains(commandName);
    }

    public static void main(String[] args) {
        System.out.println(isAuthorized("sadf"));
    }


}

